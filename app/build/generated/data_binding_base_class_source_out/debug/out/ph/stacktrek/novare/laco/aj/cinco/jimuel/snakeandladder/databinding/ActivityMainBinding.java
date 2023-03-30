// Generated by view binder compiler. Do not edit!
package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.R;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final AppCompatButton addButton;

  @NonNull
  public final Guideline bottomGuideline;

  @NonNull
  public final ConstraintLayout fragmentContainerLeaderboard;

  @NonNull
  public final FrameLayout home;

  @NonNull
  public final TextView leaderboard;

  @NonNull
  public final Guideline leftGuideline;

  @NonNull
  public final AppCompatImageView quit;

  @NonNull
  public final Guideline rightGuideline;

  @NonNull
  public final AppCompatImageView sound;

  @NonNull
  public final AppCompatButton startButton;

  @NonNull
  public final Guideline topGuideline;

  @NonNull
  public final AppCompatImageView trophy;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView,
      @NonNull AppCompatButton addButton, @NonNull Guideline bottomGuideline,
      @NonNull ConstraintLayout fragmentContainerLeaderboard, @NonNull FrameLayout home,
      @NonNull TextView leaderboard, @NonNull Guideline leftGuideline,
      @NonNull AppCompatImageView quit, @NonNull Guideline rightGuideline,
      @NonNull AppCompatImageView sound, @NonNull AppCompatButton startButton,
      @NonNull Guideline topGuideline, @NonNull AppCompatImageView trophy) {
    this.rootView = rootView;
    this.addButton = addButton;
    this.bottomGuideline = bottomGuideline;
    this.fragmentContainerLeaderboard = fragmentContainerLeaderboard;
    this.home = home;
    this.leaderboard = leaderboard;
    this.leftGuideline = leftGuideline;
    this.quit = quit;
    this.rightGuideline = rightGuideline;
    this.sound = sound;
    this.startButton = startButton;
    this.topGuideline = topGuideline;
    this.trophy = trophy;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_button;
      AppCompatButton addButton = ViewBindings.findChildViewById(rootView, id);
      if (addButton == null) {
        break missingId;
      }

      id = R.id.bottomGuideline;
      Guideline bottomGuideline = ViewBindings.findChildViewById(rootView, id);
      if (bottomGuideline == null) {
        break missingId;
      }

      ConstraintLayout fragmentContainerLeaderboard = (ConstraintLayout) rootView;

      id = R.id.home;
      FrameLayout home = ViewBindings.findChildViewById(rootView, id);
      if (home == null) {
        break missingId;
      }

      id = R.id.leaderboard;
      TextView leaderboard = ViewBindings.findChildViewById(rootView, id);
      if (leaderboard == null) {
        break missingId;
      }

      id = R.id.leftGuideline;
      Guideline leftGuideline = ViewBindings.findChildViewById(rootView, id);
      if (leftGuideline == null) {
        break missingId;
      }

      id = R.id.quit;
      AppCompatImageView quit = ViewBindings.findChildViewById(rootView, id);
      if (quit == null) {
        break missingId;
      }

      id = R.id.rightGuideline;
      Guideline rightGuideline = ViewBindings.findChildViewById(rootView, id);
      if (rightGuideline == null) {
        break missingId;
      }

      id = R.id.sound;
      AppCompatImageView sound = ViewBindings.findChildViewById(rootView, id);
      if (sound == null) {
        break missingId;
      }

      id = R.id.start_button;
      AppCompatButton startButton = ViewBindings.findChildViewById(rootView, id);
      if (startButton == null) {
        break missingId;
      }

      id = R.id.topGuideline;
      Guideline topGuideline = ViewBindings.findChildViewById(rootView, id);
      if (topGuideline == null) {
        break missingId;
      }

      id = R.id.trophy;
      AppCompatImageView trophy = ViewBindings.findChildViewById(rootView, id);
      if (trophy == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, addButton, bottomGuideline,
          fragmentContainerLeaderboard, home, leaderboard, leftGuideline, quit, rightGuideline,
          sound, startButton, topGuideline, trophy);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
