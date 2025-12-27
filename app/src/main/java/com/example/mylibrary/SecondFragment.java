package com.example.mylibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {

    private BookViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.second_fragment, container, false);

        TextView titleText = view.findViewById(R.id.text_title);
        TextView writerText = view.findViewById(R.id.text_writer);
        TextView descText = view.findViewById(R.id.text_description);
        Button backButton = view.findViewById(R.id.button_back);

        viewModel = new ViewModelProvider(requireActivity())
                .get(BookViewModel.class);

        Book book = viewModel.getSelectedBook();

        if (book != null) {
            titleText.setText(book.getTitle());
            writerText.setText(book.getWriter());
            descText.setText(book.getDescription());
        }

        backButton.setOnClickListener(v ->
                NavHostFragment.findNavController(this).navigateUp()
        );

        return view;
    }
}