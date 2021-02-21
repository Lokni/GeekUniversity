package ru.dmkalvan.inote.ui;

import android.annotation.SuppressLint;
import android.icu.text.SimpleDateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import ru.dmkalvan.inote.Constants;
import ru.dmkalvan.inote.R;
import ru.dmkalvan.inote.data.NoteData;
import ru.dmkalvan.inote.data.NoteSource;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.ViewHolder> implements Constants {

    private static final String TAG = "SocialNetworkAdapter";
    private final Fragment fragment;
    private NoteSource dataSource;
    private OnItemClickListener itemClickListener;
    private int menuPosition;

    public NoteListAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void setDataSource(NoteSource dataSource) {
        this.dataSource = dataSource;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        Log.d(TAG, "onCreateViewHolder");

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(dataSource.getNoteData(position));
        Log.d(TAG, "onBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public int getMenuPosition() {
        return menuPosition;
    }

    public void SetOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView description;
        private final TextView date;
        private final LinearLayout card;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.note_card);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);

            registerContextMenu(itemView);

            card.setOnClickListener(v -> {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v, getAdapterPosition());
                }
            });

            card.setOnLongClickListener(v -> {
                menuPosition = getLayoutPosition();
                itemView.showContextMenu(X_POS, Y_POS);
                return true;
            });
        }

        private void registerContextMenu(View itemView) {
            if (fragment != null) {
                itemView.setOnLongClickListener(v -> {
                    menuPosition = getLayoutPosition();
                    return false;
                });
                fragment.registerForContextMenu(itemView);
            }
        }

        @SuppressLint("SimpleDateFormat")
        public void setData(NoteData noteData) {
            title.setText(noteData.getTitle());
            description.setText(noteData.getDescription());
            date.setText(new SimpleDateFormat("dd-MM-yy").format(noteData.getDate()));
        }
    }
}
