package com.example.mylibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private Spinner spinner;
    private Button button;
    private BookViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.first_fragment, container, false);

        spinner = view.findViewById(R.id.spinnerbl);
        button = view.findViewById(R.id.button1);

        viewModel = new ViewModelProvider(requireActivity())
                .get(BookViewModel.class);

        loadBooks();

        button.setOnClickListener(v -> onButtonClick());

        return view;
    }

    private void loadBooks() {

        BookList loader = new BookList(requireContext().getAssets());
        List<Book> books = loader.getBooks();

        viewModel.setBooks(books);

        List<String> titles = new ArrayList<>();
        titles.add("Επιλέξτε βιβλίο");

        for (Book book : books) {
            titles.add(book.getTitle());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_spinner_item,
                titles
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinner.setAdapter(adapter);
    }

    private void onButtonClick() {

        int position = spinner.getSelectedItemPosition();

        if (position == 0) {
            Toast myToast=Toast.makeText(
                    requireContext(),
                    "Παρακαλώ επιλέξτε βιβλίο",
                    Toast.LENGTH_LONG);
            myToast.show();
            return;
        }

        Book selectedBook =
                viewModel.getBooks().get(position - 1);

        viewModel.setSelectedBook(selectedBook);

        NavHostFragment.findNavController(this)
                .navigate(R.id.action_firstFragment_to_secondFragment);
    }
}