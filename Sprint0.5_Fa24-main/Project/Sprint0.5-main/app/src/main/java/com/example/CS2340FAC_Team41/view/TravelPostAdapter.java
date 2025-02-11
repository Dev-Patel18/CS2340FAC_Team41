package com.example.CS2340FAC_Team41.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CS2340FAC_Team41.R;

import java.util.List;

import model.TravelPost;

public class TravelPostAdapter extends RecyclerView.Adapter<TravelPostAdapter.ViewHolder> {
    private final List<TravelPost> travelPosts;

    public TravelPostAdapter(List<TravelPost> travelPosts) {
        this.travelPosts = travelPosts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_travel_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TravelPost post = travelPosts.get(position);

        // Bind data to the views
        holder.tripDuration.setText("Duration: " + post.getTripDuration());
        holder.destinations.setText("Destinations: " + post.getDestinations());
        holder.notes.setText("Notes: " + post.getNotes());
        holder.startDate.setText("Start Date: " + post.getStartDate());
        holder.endDate.setText("End Date: " + post.getEndDate());
        holder.accommodations.setText("Accommodations: " + post.getAccommodations());
        holder.diningReservations.setText("Dining Reservations: " + post.getDiningReservations());
        holder.rating.setText("Rating: " + post.getRating());
    }

    @Override
    public int getItemCount() {
        return travelPosts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tripDuration, destinations, notes, startDate, endDate, accommodations, diningReservations, rating;

        ViewHolder(View itemView) {
            super(itemView);
            tripDuration = itemView.findViewById(R.id.tvTripDuration);
            destinations = itemView.findViewById(R.id.tvDestinations);
            notes = itemView.findViewById(R.id.tvNotes);
            startDate = itemView.findViewById(R.id.tvStartDate);
            endDate = itemView.findViewById(R.id.tvEndDate);
            accommodations = itemView.findViewById(R.id.tvAccommodations);
            diningReservations = itemView.findViewById(R.id.tvDiningReservations);
            rating = itemView.findViewById(R.id.tvRating);
        }
    }
}
