package com.muratcay.rickandmortyjcomposeapp.extensions

import android.annotation.SuppressLint
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.semantics.Role

inline fun <T : Any> Modifier.ifNotNull(value: T?, builder: (T) -> Modifier): Modifier =
    then(if (value != null) builder(value) else Modifier)

/**
 *  val nullableString: String? = "Hello"
 * val resultModifier = Modifier
 *     .ifNotNull(nullableString) { value ->
 *         // nullableString null değilse bu blok çalışacak
 *         Modifier.padding(16.dp)
 *     }
 *     .ifNull(nullableString) {
 *         // nullableString null ise bu blok çalışacak
 *         Modifier.padding(8.dp)
 *     }
 */

inline fun <T : Any> Modifier.ifNull(value: T?, builder: () -> Modifier): Modifier =
    then(if (value == null) builder() else Modifier)

inline fun Modifier.ifTrue(predicate: Boolean, builder: () -> Modifier) =
    then(if (predicate) builder() else Modifier)

/**
 *  val condition = true
 * val trueResult = Modifier
 *     .ifTrue(condition) {
 *         // condition true ise bu blok çalışacak
 *         Modifier.background(Color.Green)
 *     }
 *     .ifFalse(condition) {
 *         // condition false ise bu blok çalışacak (bu örnekte çalışmaz)
 *         Modifier.background(Color.Red)
 *     }
 */

inline fun Modifier.ifFalse(predicate: Boolean, builder: () -> Modifier) =
    then(if (!predicate) builder() else Modifier)

/**
 * val condition2 = false
 * val falseResult = Modifier
 *     .ifTrue(condition2) {
 *         // condition true ise bu blok çalışacak (bu örnekte çalışmaz)
 *         Modifier.background(Color.Green)
 *     }
 *     .ifFalse(condition2) {
 *         // condition false ise bu blok çalışacak
 *         Modifier.background(Color.Red)
 *     }
 */

inline fun Modifier.debounceClickable(
    debounceInterval: Long = 1000L,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    crossinline onClick: () -> Unit,
): Modifier = composed {
    this.then(
        Modifier.debounceClickable(
            debounceInterval = debounceInterval,
            interactionSource = remember { MutableInteractionSource() },
            indication = LocalIndication.current,
            enabled = enabled,
            onClickLabel = onClickLabel,
            role = role,
            onClick = onClick
        )
    )
}

/**
 * val enabledState = remember { mutableStateOf(true) }
 *
 * val modifier = Modifier
 *     .debounceClickable(
 *         debounceInterval = 1000L,
 *         enabled = enabledState.value,
 *         onClickLabel = "Button Clicked",
 *         role = Role.Button
 *     ) {
 *         // Debounce edilmiş tıklama işlemi
 *         println("Button clicked")
 *     }
 *     .padding(16.dp)
 *
 * Button(
 *     onClick = {
 *         // Butona tıklandığında enabled durumunu güncelle
 *         enabledState.value = !enabledState.value
 *     },
 *     modifier = modifier
 * ) {
 *     Text(text = "Click Me")
 * }
 */

@SuppressLint("SuspiciousModifierThen")
inline fun Modifier.debounceClickable(
    debounceInterval: Long = 1000L,
    interactionSource: MutableInteractionSource,
    indication: Indication?,
    enabled: Boolean =true,
    onClickLabel: String? = null,
    role: Role? = null,
    crossinline onClick: () -> Unit,
): Modifier = composed {
    var lastClickedTime by remember { mutableLongStateOf(0L) }
    this.then(
        clickable(
            interactionSource = interactionSource,
            indication = indication,
            enabled = enabled,
            onClickLabel = onClickLabel,
            role = role
        ) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickedTime > debounceInterval) {
                lastClickedTime = currentTime
                onClick()
            }
        }
    )
}

/**
 * val modifier = Modifier
 *     .debounceClickable(
 *         debounceInterval = 1500L,
 *         interactionSource = remember { MutableInteractionSource() },
 *         indication = rememberRipple(bounded = false),
 *         enabled = true
 *     ) {
 *         // Debounce edilmiş tıklama işlemi
 *         println("Clickable area clicked")
 *     }
 *     .fillMaxSize()
 *     .background(Color.LightGray)
 *
 * Box(
 *     modifier = modifier.clickable {
 *         // Box alanına tıklama işlemi
 *         println("Box clicked")
 *     }
 * ) {
 *     Text(
 *         text = "Click me anywhere in the box",
 *         textAlign = TextAlign.Center,
 *         modifier = Modifier.align(Alignment.Center)
 *     )
 * }
 */