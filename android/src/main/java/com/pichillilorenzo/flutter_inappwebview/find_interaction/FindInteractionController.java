package com.pichillilorenzo.flutter_inappwebview.find_interaction;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.pichillilorenzo.flutter_inappwebview.types.Disposable;
import com.pichillilorenzo.flutter_inappwebview.webview.InAppWebViewInterface;

import io.flutter.plugin.common.MethodChannel;

public class FindInteractionController implements Disposable {
  static final String LOG_TAG = "FindInteractionController";
  public static final String METHOD_CHANNEL_NAME_PREFIX = "com.pichillilorenzo/flutter_inappwebview_find_interaction_";

  @Nullable
  public InAppWebViewInterface webView;
  @Nullable
  public FindInteractionChannelDelegate channelDelegate;
  @Nullable
  public FindInteractionSettings settings;

  public FindInteractionController(@NonNull InAppWebViewInterface webView, @NonNull InAppWebViewFlutterPlugin plugin,
                             @NonNull Object id, @Nullable FindInteractionSettings settings) {
    this.webView = webView;
    this.settings = settings;
    final MethodChannel channel = new MethodChannel(plugin.messenger, METHOD_CHANNEL_NAME_PREFIX + id);
    this.channelDelegate = new FindInteractionChannelDelegate(this, channel);
  }

  public void prepare() {

  }

  public void dispose() {
    if (channelDelegate != null) {
      channelDelegate.dispose();
      channelDelegate = null;
    }
    webView = null;
  }
}
