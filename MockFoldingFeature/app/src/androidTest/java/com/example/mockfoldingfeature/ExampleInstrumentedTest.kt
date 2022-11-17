package com.example.mockfoldingfeature

import android.util.Log
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.window.layout.FoldingFeature
import androidx.window.testing.layout.FoldingFeature
import androidx.window.testing.layout.TestWindowLayoutInfo
import androidx.window.testing.layout.WindowLayoutInfoPublisherRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private val composeTestRule = createAndroidComposeRule<MainActivity>()
    private val publisherRule = WindowLayoutInfoPublisherRule()

    @get:Rule
    val testRule: TestRule

    init {
        testRule = RuleChain.outerRule(publisherRule).around(composeTestRule)
    }

    @Test
    fun simulateVerticalFoldingFeature() {
        // Simulate a vertical FoldingFeature
        composeTestRule.activityRule.scenario.onActivity { activity ->
            val verticalFoldingFeature = FoldingFeature(
                activity = activity,
                orientation = FoldingFeature.Orientation.VERTICAL
            )
            Log.d("TestDebugTag", verticalFoldingFeature.bounds.toString())
            val windowLayoutInfo = TestWindowLayoutInfo(listOf(verticalFoldingFeature))
            publisherRule.overrideWindowLayoutInfo(windowLayoutInfo)
        }

        // Find the nodes to test and 4. Perform assertions on the nodes
        composeTestRule.onNodeWithText("pane1").assertIsDisplayed()
        composeTestRule.onNodeWithText("pane2").assertIsDisplayed()
    }
}