// Copyright 2013 Square, Inc.

package com.squareup.timessquare;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.squareup.timessquare.MonthCellDescriptor.RangeState;

public class CalendarCellView extends TextView {
  private static final int[] STATE_SELECTABLE = {
      R.attr.tsquare_state_selectable
  };
  private static final int[] STATE_CURRENT_MONTH = {
      R.attr.tsquare_state_current_month
  };
  private static final int[] STATE_TODAY = {
      R.attr.tsquare_state_today
  };
  private static final int[] STATE_FIRST_DAY_OF_WEEK = {
      R.attr.tsquare_state_first_day_of_week
  };
  private static final int[] STATE_LAST_DAY_OF_WEEK = {
      R.attr.tsquare_state_last_day_of_week
  };
  private static final int[] STATE_FIRST_DAY_OF_MONTH = {
      R.attr.tsquare_state_first_day_of_month
  };
  private static final int[] STATE_LAST_DAY_OF_MONTH = {
      R.attr.tsquare_state_last_day_of_month
  };
  private static final int[] STATE_HIGHLIGHTED = {
      R.attr.tsquare_state_highlighted
  };
  private static final int[] STATE_RANGE_FIRST = {
      R.attr.tsquare_state_range_first
  };
  private static final int[] STATE_RANGE_MIDDLE = {
      R.attr.tsquare_state_range_middle
  };
  private static final int[] STATE_RANGE_LAST = {
      R.attr.tsquare_state_range_last
  };
  private static final int[] STATE_SECONDARY_SELECTED = {
      R.attr.tsquare_state_secondary_selected
  };

  private boolean isSelectable = false;
  private boolean isCurrentMonth = false;
  private boolean isToday = false;
  private boolean isFirstDayOfWeek = false;
  private boolean isLastDayOfWeek = false;
  private boolean isFirstDayOfMonth = false;
  private boolean isLastDayOfMonth = false;
  private boolean isHighlighted = false;
  private RangeState rangeState = RangeState.NONE;
  private boolean isSecondarySelected = false;

  @SuppressWarnings("UnusedDeclaration") //
  public CalendarCellView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public void setFirstDayOfWeek(boolean isFirstDayOfWeek) {
    this.isFirstDayOfWeek = isFirstDayOfWeek;
    refreshDrawableState();
  }

  public void setLastDayOfWeek(boolean isLastDayOfWeek) {
    this.isLastDayOfWeek = isLastDayOfWeek;
    refreshDrawableState();
  }

  public void setFirstDayOfMonth(boolean isFirstDayOfMonth) {
    this.isFirstDayOfMonth = isFirstDayOfMonth;
    refreshDrawableState();
  }

  public void setLastDayOfMonth(boolean isLastDayOfMonth) {
    this.isLastDayOfMonth = isLastDayOfMonth;
    refreshDrawableState();
  }

  public void setSelectable(boolean isSelectable) {
    this.isSelectable = isSelectable;
    refreshDrawableState();
  }

  public void setCurrentMonth(boolean isCurrentMonth) {
    this.isCurrentMonth = isCurrentMonth;
    refreshDrawableState();
  }

  public void setToday(boolean isToday) {
    this.isToday = isToday;
    refreshDrawableState();
  }

  public void setRangeState(MonthCellDescriptor.RangeState rangeState) {
    this.rangeState = rangeState;
    refreshDrawableState();
  }

  public void setHighlighted(boolean highlighted) {
    isHighlighted = highlighted;
    refreshDrawableState();
  }

  public void setSecondarySelected(boolean isSecondarySelected) {
    this.isSecondarySelected = isSecondarySelected;
    refreshDrawableState();
  }

  public boolean isCurrentMonth() {
    return isCurrentMonth;
  }

  public boolean isToday() {
    return isToday;
  }

  public boolean isFirstDayOfWeek() {
    return isFirstDayOfWeek;
  }

  public boolean isLastDayOfWeek() {
    return isLastDayOfWeek;
  }

  public boolean isFirstDayOfMonth() {
    return isFirstDayOfMonth;
  }

  public boolean isLastDayOfMonth() {
    return isLastDayOfMonth;
  }

  public boolean isSelectable() {
    return isSelectable;
  }

  public boolean isSecondarySelected() {
    return isSecondarySelected;
  }

  @Override protected int[] onCreateDrawableState(int extraSpace) {
    final int[] drawableState = super.onCreateDrawableState(extraSpace + 6);

    if (isSelectable) {
      mergeDrawableStates(drawableState, STATE_SELECTABLE);
    }

    if (isCurrentMonth) {
      mergeDrawableStates(drawableState, STATE_CURRENT_MONTH);
    }

    if (isToday) {
      mergeDrawableStates(drawableState, STATE_TODAY);
    }

    if (isFirstDayOfWeek) {
      mergeDrawableStates(drawableState, STATE_FIRST_DAY_OF_WEEK);
    }

    if (isLastDayOfWeek) {
      mergeDrawableStates(drawableState, STATE_LAST_DAY_OF_WEEK);
    }

    if (isFirstDayOfMonth) {
      mergeDrawableStates(drawableState, STATE_FIRST_DAY_OF_MONTH);
    }

    if (isLastDayOfMonth) {
      mergeDrawableStates(drawableState, STATE_LAST_DAY_OF_MONTH);
    }

    if (isHighlighted) {
      mergeDrawableStates(drawableState, STATE_HIGHLIGHTED);
    }

    if (rangeState == MonthCellDescriptor.RangeState.FIRST) {
      mergeDrawableStates(drawableState, STATE_RANGE_FIRST);
    } else if (rangeState == MonthCellDescriptor.RangeState.MIDDLE) {
      mergeDrawableStates(drawableState, STATE_RANGE_MIDDLE);
    } else if (rangeState == RangeState.LAST) {
      mergeDrawableStates(drawableState, STATE_RANGE_LAST);
    }

    if (isSecondarySelected) {
      mergeDrawableStates(drawableState, STATE_SECONDARY_SELECTED);
    }

    return drawableState;
  }
}
