// Generated by view binder compiler. Do not edit!
package ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ph.stacktrek.novare.laco.aj.cinco.jimuel.snakeandladder.R;

public final class MusicBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout musicDialogue;

  @NonNull
  public final RadioButton radioButton1;

  @NonNull
  public final RadioButton radioButton2;

  @NonNull
  public final RadioGroup radioGroup;

  @NonNull
  public final Switch switch1;

  @NonNull
  public final SeekBar volume;

  private MusicBinding(@NonNull ConstraintLayout rootView, @NonNull ConstraintLayout musicDialogue,
      @NonNull RadioButton radioButton1, @NonNull RadioButton radioButton2,
      @NonNull RadioGroup radioGroup, @NonNull Switch switch1, @NonNull SeekBar volume) {
    this.rootView = rootView;
    this.musicDialogue = musicDialogue;
    this.radioButton1 = radioButton1;
    this.radioButton2 = radioButton2;
    this.radioGroup = radioGroup;
    this.switch1 = switch1;
    this.volume = volume;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MusicBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MusicBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.music, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MusicBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout musicDialogue = (ConstraintLayout) rootView;

      id = R.id.radio_button1;
      RadioButton radioButton1 = ViewBindings.findChildViewById(rootView, id);
      if (radioButton1 == null) {
        break missingId;
      }

      id = R.id.radio_button2;
      RadioButton radioButton2 = ViewBindings.findChildViewById(rootView, id);
      if (radioButton2 == null) {
        break missingId;
      }

      id = R.id.radio_group;
      RadioGroup radioGroup = ViewBindings.findChildViewById(rootView, id);
      if (radioGroup == null) {
        break missingId;
      }

      id = R.id.switch1;
      Switch switch1 = ViewBindings.findChildViewById(rootView, id);
      if (switch1 == null) {
        break missingId;
      }

      id = R.id.volume;
      SeekBar volume = ViewBindings.findChildViewById(rootView, id);
      if (volume == null) {
        break missingId;
      }

      return new MusicBinding((ConstraintLayout) rootView, musicDialogue, radioButton1,
          radioButton2, radioGroup, switch1, volume);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
