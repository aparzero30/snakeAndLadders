// Generated by view binder compiler. Do not edit!
package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.R;

public final class PortalDialogueBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout portal;

  @NonNull
  public final ImageView portalImg;

  @NonNull
  public final TextView portaltxt;

  private PortalDialogueBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout portal, @NonNull ImageView portalImg, @NonNull TextView portaltxt) {
    this.rootView = rootView;
    this.portal = portal;
    this.portalImg = portalImg;
    this.portaltxt = portaltxt;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PortalDialogueBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PortalDialogueBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.portal_dialogue, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PortalDialogueBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout portal = (ConstraintLayout) rootView;

      id = R.id.portalImg;
      ImageView portalImg = ViewBindings.findChildViewById(rootView, id);
      if (portalImg == null) {
        break missingId;
      }

      id = R.id.portaltxt;
      TextView portaltxt = ViewBindings.findChildViewById(rootView, id);
      if (portaltxt == null) {
        break missingId;
      }

      return new PortalDialogueBinding((ConstraintLayout) rootView, portal, portalImg, portaltxt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}