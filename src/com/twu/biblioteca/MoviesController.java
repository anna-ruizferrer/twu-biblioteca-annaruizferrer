package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoviesController {
    private List<Movie> movies = new ArrayList<Movie>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAvailableMovies() {
        List<Movie> availables = new ArrayList<Movie>();
        for (Movie m : movies) {
            if (m.isAvailable()) {
                availables.add(m);
            }
        }
        return availables;
    }

    public void loadCatalog() {
        try {
            File file = new File("doc/movies_database.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int id = 1;
            while ((line = bufferedReader.readLine()) != null) {
                String[] m = line.split("\t");
                addMovie(new Movie(id++, m[0], m[1], m[2], m[3]));
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
