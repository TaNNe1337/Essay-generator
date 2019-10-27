package com.qualitype.Essay;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.RandomWalkIterator;

public class Essay {

	private DefaultDirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);

	public DefaultDirectedGraph<String, DefaultEdge> getG() {
		return g;
	}

	public void setG(DefaultDirectedGraph<String, DefaultEdge> g) {
		this.g = g;
	}

	public String generateEssay() {
		if (g != null) {
			final List<String> newText = new ArrayList<String>();
			final RandomWalkIterator<String, DefaultEdge> rwi = new RandomWalkIterator<String, DefaultEdge>(g);
			while (rwi.hasNext()) {
				newText.add(rwi.next());
			}
			newText.remove(newText.size() - 1);
			final StringBuilder sb = new StringBuilder();
			for (final String string : newText) {
				sb.append(string + " ");
			}

			return sb.toString();
		}
		return null;

	}

	public void readText(Path path) {
		List<String> list = new ArrayList<String>();
		try {
			list = Files.readAllLines(path);
		} catch (final IOException e) {
			e.printStackTrace();
		}

		if (!list.isEmpty()) {
			for (final String line : list) {
				final String[] words = line.split("\\s");
				for (final String word : words) {
					g.addVertex(word);
				}
				for (int i = 0; i < words.length - 1; i++) {
					g.addEdge(words[i], words[i + 1]);
				}
			}

		}
	}
}
