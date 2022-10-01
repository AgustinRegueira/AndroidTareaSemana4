package edu.utec.tareasemana4;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import edu.utec.tareasemana4.domain.entities.UserDto;

public class UserListAdapter extends ListAdapter<UserDto, UserViewHolder> {

    public interface OnItemClickListener{
        void onItemClick(UserDto user);
    }

    private OnItemClickListener listener;

    protected UserListAdapter(@NonNull DiffUtil.ItemCallback<UserDto> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return UserViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserDto currentUser = getItem(position);
        holder.bind(currentUser.getNombre(), currentUser.getApellido(), currentUser.getTipoUsuario());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null) {
                    listener.onItemClick(currentUser);
                }
            }
        });
    }

    static class UserDiff extends DiffUtil.ItemCallback<UserDto> {

        @Override
        public boolean areItemsTheSame(@NonNull UserDto oldItem, @NonNull UserDto newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull UserDto oldItem, @NonNull UserDto newItem) {
            return oldItem.getNombre().equals(newItem.getNombre()) &&
                    oldItem.getApellido().equals(newItem.getApellido()) &&
                    oldItem.getTipoUsuario().equals(newItem.getTipoUsuario());
        }
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
