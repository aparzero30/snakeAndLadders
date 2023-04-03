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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.R;

public final class MapLegendBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView descriptionLadder;

  @NonNull
  public final TextView descriptionSnake;

  @NonNull
  public final FrameLayout ladderFrame;

  @NonNull
  public final ImageView ladderPhoto;

  @NonNull
  public final ConstraintLayout mapLegend;

  @NonNull
  public final FrameLayout snakeFrame;

  @NonNull
  public final ImageView snakePhoto;

  private MapLegendBinding(@NonNull ConstraintLayout rootView, @NonNull TextView descriptionLadder,
      @NonNull TextView descriptionSnake, @NonNull FrameLayout ladderFrame,
      @NonNull ImageView ladderPhoto, @NonNull ConstraintLayout mapLegend,
      @NonNull FrameLayout snakeFrame, @NonNull ImageView snakePhoto) {
    this.rootView = rootView;
    this.descriptionLadder = descriptionLadder;
    this.descriptionSnake = descriptionSnake;
    this.ladderFrame = ladderFrame;
    this.ladderPhoto = ladderPhoto;
    this.mapLegend = mapLegend;
    this.snakeFrame = snakeFrame;
    this.snakePhoto = snakePhoto;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MapLegendBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MapLegendBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.map_legend, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MapLegendBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.description_ladder;
      TextView descriptionLadder = ViewBindings.findChildViewById(rootView, id);
      if (descriptionLadder == null) {
        break missingId;
      }

      id = R.id.description_snake;
      TextView descriptionSnake = ViewBindings.findChildViewById(rootView, id);
      if (descriptionSnake == null) {
        break missingId;
      }

      id = R.id.ladder_frame;
      FrameLayout ladderFrame = ViewBindings.findChildViewById(rootView, id);
      if (ladderFrame == null) {
        break missingId;
      }

      id = R.id.ladder_photo;
      ImageView ladderPhoto = ViewBindings.findChildViewById(rootView, id);
      if (ladderPhoto == null) {
        break missingId;
      }

      ConstraintLayout mapLegend = (ConstraintLayout) rootView;

      id = R.id.snake_frame;
      FrameLayout snakeFrame = ViewBindings.findChildViewById(rootView, id);
      if (snakeFrame == null) {
        break missingId;
      }

      id = R.id.snake_photo;
      ImageView snakePhoto = ViewBindings.findChildViewById(rootView, id);
      if (snakePhoto == null) {
        break missingId;
      }

      return new MapLegendBinding((ConstraintLayout) rootView, descriptionLadder, descriptionSnake,
          ladderFrame, ladderPhoto, mapLegend, snakeFrame, snakePhoto);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}