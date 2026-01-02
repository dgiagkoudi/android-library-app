package com.example.mylibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private Spinner spinner;
    private Button button;
    private ChipGroup chipGroupCategories;
    private BookViewModel viewModel;
    private List<Book> currentBooksInSpinner = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.first_fragment, container, false);

        spinner = view.findViewById(R.id.spinnerbl);
        button = view.findViewById(R.id.button1);
        chipGroupCategories = view.findViewById(R.id.chipGroupCategories);

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
        updateSpinner(books);

        String[] categories = Categories.all();

        for (String category : categories) {
            Chip chip = new Chip(requireContext());
            chip.setText(category);
            chip.setCheckable(true);
            chipGroupCategories.addView(chip);
        }

        chipGroupCategories.setOnCheckedStateChangeListener((group, checkedIds) -> {
            List<Book> allBooks = viewModel.getBooks();
            List<Book> filteredBooks = new ArrayList<>();

            clearSpinner();

            if (checkedIds.isEmpty()) {
                filteredBooks.addAll(allBooks);
            } else {
                Chip selectedChip = group.findViewById(checkedIds.get(0));
                String selectedCategory = selectedChip.getText().toString();

                for (Book book : allBooks) {
                    if (book.getCategory().equals(selectedCategory)) {
                        filteredBooks.add(book);
                    }
                }
            }

            updateSpinner(filteredBooks);
        });
    }

    private void updateSpinner(List<Book> booksToShow) {
        currentBooksInSpinner.clear();
        currentBooksInSpinner.addAll(booksToShow);

        List<String> titles = new ArrayList<>();
        titles.add("Επιλέξτε βιβλίο");

        for (Book book : booksToShow) {
            titles.add(book.getTitle());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                R.layout.spinner_item,
                titles
        );
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);
    }

    private void clearSpinner() {
        spinner.setAdapter(null);
    }

    private void onButtonClick() {
        int position = spinner.getSelectedItemPosition();

        if (position == 0) {
            android.widget.Toast.makeText(
                    requireContext(),
                    "Παρακαλώ επιλέξτε βιβλίο",
                    android.widget.Toast.LENGTH_LONG).show();
            return;
        }

        Book selectedBook = currentBooksInSpinner.get(position - 1);

        viewModel.setSelectedBook(selectedBook);

        NavHostFragment.findNavController(this)
                .navigate(R.id.action_firstFragment_to_secondFragment);
    }

    @Override
    public void onResume() {
        super.onResume();

        clearSpinner();

        chipGroupCategories.clearCheck();
        updateSpinner(viewModel.getBooks());
    }
}