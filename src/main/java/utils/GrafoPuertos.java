
package utils;

import java.util.*;

public class GrafoPuertos {
    private Map<String, Map<String, Integer>> adyacencias = new HashMap<>();

    public void agregarPuerto(String puerto) {
        adyacencias.putIfAbsent(puerto, new HashMap<>());
    }

    public void conectar(String origen, String destino, int distancia) {
        adyacencias.get(origen).put(destino, distancia);
        adyacencias.get(destino).put(origen, distancia);
    }

    public void dfs(String inicio, Set<String> visitado) {
        System.out.println("Visitando: " + inicio);
        visitado.add(inicio);
        for (String vecino : adyacencias.get(inicio).keySet()) {
            if (!visitado.contains(vecino)) {
                dfs(vecino, visitado);
            }
        }
    }

    public void barridoProfundidad(String inicio) {
        Set<String> visitado = new HashSet<>();
        dfs(inicio, visitado);
    }

    public List<String> caminoMasCorto(String inicio, String destino) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String nodo : adyacencias.keySet()) {
            dist.put(nodo, Integer.MAX_VALUE);
        }
        dist.put(inicio, 0);
        pq.add(inicio);

        while (!pq.isEmpty()) {
            String actual = pq.poll();
            for (Map.Entry<String, Integer> vecino : adyacencias.get(actual).entrySet()) {
                int nuevaDist = dist.get(actual) + vecino.getValue();
                if (nuevaDist < dist.get(vecino.getKey())) {
                    dist.put(vecino.getKey(), nuevaDist);
                    prev.put(vecino.getKey(), actual);
                    pq.add(vecino.getKey());
                }
            }
        }

        List<String> camino = new LinkedList<>();
        String actual = destino;
        while (actual != null) {
            camino.add(0, actual);
            actual = prev.get(actual);
        }
        return camino;
    }

    public void eliminarPuertoConMasConexiones() {
        String masConectado = adyacencias.entrySet().stream()
                .max(Comparator.comparingInt(e -> e.getValue().size()))
                .map(Map.Entry::getKey).orElse(null);

        if (masConectado != null) {
            adyacencias.remove(masConectado);
            for (Map<String, Integer> conexiones : adyacencias.values()) {
                conexiones.remove(masConectado);
            }
            System.out.println("Eliminado puerto: " + masConectado);
        }
    }
}
