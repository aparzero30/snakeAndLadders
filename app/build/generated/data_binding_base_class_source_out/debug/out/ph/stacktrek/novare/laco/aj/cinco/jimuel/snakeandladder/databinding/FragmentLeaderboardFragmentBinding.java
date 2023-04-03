// Generated by view binder compiler. Do not edit!
package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.R;

public final class FragmentLeaderboardFragmentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Guideline bottomGuideline;

  @NonNull
  public final ConstraintLayout fragmentContainer;

  @NonNull
  public final FrameLayout frame1;

  @NonNull
  public final FrameLayout frame2;

  @NonNull
  public final FrameLayout frame3;

  @NonNull
  public final FrameLayout frame4;

  @NonNull
  public final FrameLayout frame5;

  @NonNull
  public final TextView leaderboard;

  @NonNull
  public final Guideline leftGuideline;

  @NonNull
  public final ImageView top1;

  @NonNull
  public final ImageView top2;

  @NonNull
  public final ImageView top3;

  @NonNull
  public final ImageView top4;

  @NonNull
  public final ImageView top5;

  @NonNull
  public final Guideline topGuideline;

  private FragmentLeaderboardFragmentBinding(@NonNull ConstraintLayout rootView,
      @NonNull Guideline bottomGuideline, @NonNull ConstraintLayout fragmentContainer,
      @NonNull FrameLayout frame1, @NonNull FrameLayout frame2, @NonNull FrameLayout frame3,
      @NonNull FrameLayout frame4, @NonNull FrameLayout frame5, @NonNull TextView leaderboard,
      @NonNull Guideline leftGuideline, @NonNull ImageView top1, @NonNull ImageView top2,
      @NonNull ImageView top3, @NonNull ImageView top4, @NonNull ImageView top5,
      @NonNull Guideline topGuideline) {
    this.rootView = rootView;
    this.bottomGuideline = bottomGuideline;
    this.fragmentContainer = fragmentContainer;
    this.frame1 = frame1;
    this.frame2 = frame2;
    this.frame3 = frame3;
    this.frame4 = frame4;
    this.frame5 = frame5;
    this.leaderboard = leaderboard;
    this.leftGuideline = leftGuideline;
    this.top1 = top1;
    this.top2 = top2;
    this.top3 = top3;
    this.top4 = top4;
    this.top5 = top5;
    this.topGuideline = topGuideline;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLeaderboardFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLeaderboardFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_leaderboard_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLeaderboardFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottomGuideline;
      Guideline bottomGuideline = ViewBindings.findChildViewById(rootView, id);
      if (bottomGuideline == null) {
        break missingId;
      }

      ConstraintLayout fragmentContainer = (ConstraintLayout) rootView;

      id = R.id.frame1;
      FrameLayout frame1 = ViewBindings.findChildViewById(rootView, id);
      if (frame1 == null) {
        break missingId;
      }

      id = R.id.frame2;
      FrameLayout frame2 = ViewBindings.findChildViewById(rootView, id);
      if (frame2 == null) {
        break missingId;
      }

      id = R.id.frame3;
      FrameLayout frame3 = ViewBindings.findChildViewById(rootView, id);
      if (frame3 == null) {
        break missingId;
      }

      id = R.id.frame4;
      FrameLayout frame4 = ViewBindings.findChildViewById(rootView, id);
      if (frame4 == null) {
        break missingId;
      }

      id = R.id.frame5;
      FrameLayout frame5 = ViewBindings.findChildViewById(rootView, id);
      if (frame5 == null) {
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

      id = R.id.top1;
      ImageView top1 = ViewBindings.findChildViewById(rootView, id);
      if (top1 == null) {
        break missingId;
      }

      id = R.id.top2;
      ImageView top2 = ViewBindings.findChildViewById(rootView, id);
      if (top2 == null) {
        break missingId;
      }

      id = R.id.top3;
      ImageView top3 = ViewBindings.findChildViewById(rootView, id);
      if (top3 == null) {
        break missingId;
      }

      id = R.id.top4;
      ImageView top4 = ViewBindings.findChildViewById(rootView, id);
      if (top4 == null) {
        break missingId;
      }

      id = R.id.top5;
      ImageView top5 = ViewBindings.findChildViewById(rootView, id);
      if (top5 == null) {
        break missingId;
      }

      id = R.id.topGuideline;
      Guideline topGuideline = ViewBindings.findChildViewById(rootView, id);
      if (topGuideline == null) {
        break missingId;
      }

      return new FragmentLeaderboardFragmentBinding((ConstraintLayout) rootView, bottomGuideline,
          fragmentContainer, frame1, frame2, frame3, frame4, frame5, leaderboard, leftGuideline,
          top1, top2, top3, top4, top5, topGuideline);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
