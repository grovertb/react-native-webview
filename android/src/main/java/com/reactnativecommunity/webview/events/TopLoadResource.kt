package com.reactnativecommunity.webview.events

import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event
import com.facebook.react.uimanager.events.RCTEventEmitter

/**
 * Event emitted when shouldOverrideUrlLoading is called
 */
class TopLoadResource(viewId: Int, private val mData: WritableMap) : Event<TopLoadResource>(viewId) {
  companion object {
    const val EVENT_NAME = "topLoadResource"
  }

  init {
    mData.putString("navigationType", "other")
    // Android does not raise shouldOverrideUrlLoading for inner frames
    mData.putBoolean("isTopFrame", true)
  }

  override fun getEventName(): String = EVENT_NAME

  override fun canCoalesce(): Boolean = false

  override fun getCoalescingKey(): Short = 0

  override fun dispatch(rctEventEmitter: RCTEventEmitter) =
    rctEventEmitter.receiveEvent(viewTag, EVENT_NAME, mData)
}
