package com.nadim.jogajogapplication.MainDashboard.NotificationAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nadim.jogajogapplication.MainDashboard.Models.NotificationModel;

import com.nadim.jogajogapplication.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NotificationCallAdapter extends RecyclerView.Adapter<NotificationCallAdapter.ViewHolder>  {

    private List<NotificationModel> list;
    private Context context;
    private RecyclerViewClickListener notificationListener;
    private String token;

    public NotificationCallAdapter(List<NotificationModel> list, Context context, RecyclerViewClickListener notificationListener, String token) {
        this.list = list;
        this.context = context;
        this.notificationListener = notificationListener;
        this.token = token;
    }

    @NonNull
    @Override
    public NotificationCallAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_view_holder_show, viewGroup, false);
        return new NotificationCallAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationCallAdapter.ViewHolder holder, int position) {
        final NotificationModel notificationModel = list.get(position);

        String todayDiscussion = notificationModel.getTodayDiscussion();
        String reason = notificationModel.getMeetingReason();
        String person = notificationModel.getContact().getName();
        String remainderDate = notificationModel.getReminderDate();
        String remarks = notificationModel.getNextDiscussion();
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        DateFormat outputFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aaa");




        holder.reasonShow.setText(reason);
        holder.personName.setText(person);
        holder.remarks.setText(remarks);

        Date date = null;
        try {
            date = inputFormat.parse(remainderDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String outputDateStr = outputFormat.format(date);
        holder.reminderDate.setText(outputDateStr);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        private TextView reasonShow,personName,reminderDate,remarks,checkTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            reasonShow = itemView.findViewById(R.id.reasonShow);
            personName = itemView.findViewById(R.id.personName);
            reminderDate = itemView.findViewById(R.id.reminderDate);
            remarks = itemView.findViewById(R.id.remarks);
            checkTime = itemView.findViewById(R.id.checkTime);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            notificationListener.onClick(itemView,getAdapterPosition());
        }
    }



    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
