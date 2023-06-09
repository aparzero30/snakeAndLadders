// Generated by view binder compiler. Do not edit!
package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.R;

public final class AddPlayerBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout addPlayer;

  @NonNull
  public final FrameLayout avatar;

  @NonNull
  public final ImageView avatar1;

  @NonNull
  public final ImageView avatar2;

  @NonNull
  public final ImageView avatar3;

  @NonNull
  public final ImageView avatar4;

  @NonNull
  public final ImageView avatar5;

  @NonNull
  public final TextInputLayout playerInput;

  @NonNull
  public final TextInputEditText playerName;

  private AddPlayerBinding(@NonNull ConstraintLayout rootView, @NonNull ConstraintLayout addPlayer,
      @NonNull FrameLayout avatar, @NonNull ImageView avatar1, @NonNull ImageView avatar2,
      @NonNull ImageView avatar3, @NonNull ImageView avatar4, @NonNull ImageView avatar5,
      @NonNull TextInputLayout playerInput, @NonNull TextInputEditText playerName) {
    this.rootView = rootView;
    this.addPlayer = addPlayer;
    this.avatar = avatar;
    this.avatar1 = avatar1;
    this.avatar2 = avatar2;
    this.avatar3 = avatar3;
    this.avatar4 = avatar4;
    this.avatar5 = avatar5;
    this.playerInput = playerInput;
    this.playerName = playerName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AddPlayerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AddPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.add_player, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AddPlayerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout addPlayer = (ConstraintLayout) rootView;

      id = R.id.avatar;
      FrameLayout avatar = ViewBindings.findChildViewById(rootView, id);
      if (avatar == null) {
        break missingId;
      }

      id = R.id.avatar1;
      ImageView avatar1 = ViewBindings.findChildViewById(rootView, id);
      if (avatar1 == null) {
        break missingId;
      }

      id = R.id.avatar2;
      ImageView avatar2 = ViewBindings.findChildViewById(rootView, id);
      if (avatar2 == null) {
        break missingId;
      }

      id = R.id.avatar3;
      ImageView avatar3 = ViewBindings.findChildViewById(rootView, id);
      if (avatar3 == null) {
        break missingId;
      }

      id = R.id.avatar4;
      ImageView avatar4 = ViewBindings.findChildViewById(rootView, id);
      if (avatar4 == null) {
        break missingId;
      }

      id = R.id.avatar5;
      ImageView avatar5 = ViewBindings.findChildViewById(rootView, id);
      if (avatar5 == null) {
        break missingId;
      }

      id = R.id.player_input;
      TextInputLayout playerInput = ViewBindings.findChildViewById(rootView, id);
      if (playerInput == null) {
        break missingId;
      }

      id = R.id.player_name;
      TextInputEditText playerName = ViewBindings.findChildViewById(rootView, id);
      if (playerName == null) {
        break missingId;
      }

      return new AddPlayerBinding((ConstraintLayout) rootView, addPlayer, avatar, avatar1, avatar2,
          avatar3, avatar4, avatar5, playerInput, playerName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
