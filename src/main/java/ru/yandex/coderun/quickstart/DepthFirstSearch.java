package ru.yandex.coderun.quickstart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 18. Поиск в глубину
 */
public class DepthFirstSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        Пример ввода и вывода числа n, где -10^9 < n < 10^9:
        int n = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(n));
        */

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // количество вершин в графе
        int m = Integer.parseInt(input[1]); // количество рёбер в графе

        // Инициализируем список смежности графа.
        // Используем n + 1, так как вершины нумеруются с 1
        List<Integer>[] adj = new ArrayList[n + 1]; // массив списков
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Считываем ребра
        for (int i = 0; i < m; i++) {
            input = reader.readLine().split(" ");
            int u = Integer.parseInt(input[0]) - 1;
            int v = Integer.parseInt(input[1]) - 1;

            // Граф неориентированный. Петли и кратные ребра обрабатываются корректно
            adj[u].add(v);
            adj[v].add(u);
        }

        // Список для хранения вершин нашей компоненты связности
        ArrayList<Integer> component = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        // Запускаем DFS из вершины 1
        dfs(1, adj, visited, component);

        // Сортируем вершины компоненты по возрастанию, как требует условие
        Collections.sort(component);

        // Выводим количество вершин
        writer.write(component.size() + "\n");

        // Выводим сами вершины через пробел
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < component.size(); i++) {
            sb.append(component.get(i));
            if (i < component.size() - 1) {
                sb.append(" ");
            }
        }
        writer.write(sb.toString() + "\n");

        reader.close();
        writer.close();
    }

    private static void dfs(int v, List<Integer>[] adj, boolean[] visited, ArrayList<Integer> component) {
        visited[v] = true;
        component.add(v);

        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, component);
            }
        }
    }
}
