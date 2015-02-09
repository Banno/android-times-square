package com.squareup.timessquare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

public class MonthAdapter<T extends MonthCellDescriptor> extends BaseAdapter {

    private final List<MonthDescriptor> months;
    private final List<List<List<T>>> cells;
    private boolean displayOnly;

    protected final MonthView.Listener listener;
    protected final LayoutInflater inflater;
    protected DateFormat weekdayNameFormat;
    protected Calendar today;
    protected int dividerColor;
    protected int dayBackgroundResId;
    protected int dayTextColorResId;
    protected int titleTextColor;
    protected int headerTextColor;

    public MonthAdapter(Context context, List<MonthDescriptor> months,
                        List<List<List<T>>> cells,
                        MonthView.Listener listener) {
        this.months = months;
        this.cells = cells;
        this.listener = listener;
        inflater = LayoutInflater.from(context);
    }

    @Override public boolean isEnabled(int position) {
        // Disable selectability: each cell will handle that itself.
        return false;
    }

    @Override public int getCount() {
        return months.size();
    }

    @Override public Object getItem(int position) {
        return months.get(position);
    }

    @Override public long getItemId(int position) {
        return position;
    }

    public void configure(Calendar today, boolean displayOnly, int dividerColor,
                          int dayBackgroundResId, int dayTextColorResId, int titleTextColor,
                          int headerTextColor) {
        this.today = today;
        this.displayOnly = displayOnly;
        this.dividerColor = dividerColor;
        this.dayBackgroundResId = dayBackgroundResId;
        this.dayTextColorResId = dayTextColorResId;
        this.titleTextColor = titleTextColor;
        this.headerTextColor = headerTextColor;
    }

    public void setWeekdayNameFormat(DateFormat dateFormat) {
        weekdayNameFormat = dateFormat;
    }

    @SuppressWarnings("unchecked")
    @Override public View getView(int position, View convertView, ViewGroup parent) {
        MonthView<?, T> monthView = (MonthView<?, T>) convertView;

        if (monthView == null) {
            monthView = createMonthView(parent);
        }

        monthView.init(months.get(position), cells.get(position), displayOnly);

        monthView.setFocusable(false);
        monthView.setFocusableInTouchMode(false);

        return monthView;
    }

    @SuppressWarnings("unchecked")
    protected MonthView<?, T> createMonthView(ViewGroup parent) {
        return MonthView.create(parent, inflater,
                weekdayNameFormat, listener, today, dividerColor,
                dayBackgroundResId, dayTextColorResId, titleTextColor,
                headerTextColor);
    }

}
