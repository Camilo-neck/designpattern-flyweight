// src/implementacion/ListaReproduccion.java
package implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {
    private String NombreLista;
    private List<Cancion> Canciones = new ArrayList<>();
    private int uso;

    public ListaReproduccion(String NombreLista) {
        this.NombreLista = NombreLista;
        this.uso = 0;
    }

    public String getNombreLista() {
        return NombreLista;
    }

    public void setNombreLista(String NombreLista) {
        this.NombreLista = NombreLista;
    }

    public List<Cancion> getCanciones() {
        return Canciones;
    }

    public void setCanciones(List<Cancion> Canciones) {
        this.Canciones = Canciones;
    }

    public void addCancion(String NombreCancion, Artista artista) {
        Canciones.add(FabricaCanciones.CrearItem(NombreCancion, artista));
    }

    public void ImprimirLista() {
        String out = "\nPlayList > " + NombreLista;
        for (Cancion playItem : Canciones) {
            out += "\n\t" + playItem.toString();
        }
        System.out.println(out);
        uso++;
    }

    public int getUso() {
        return uso;
    }

    public void setUso(int uso) {
        this.uso = uso;
    }

    public void saveToDatabase() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO listas_reproduccion (nombre_lista, canciones) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, NombreLista);
            pstmt.setString(2, Canciones.toString()); // Simplificación, se recomienda serializar adecuadamente
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ListaReproduccion loadFromDatabase(String nombreLista) {
        ListaReproduccion lista = null;
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM listas_reproduccion WHERE nombre_lista = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nombreLista);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                lista = new ListaReproduccion(rs.getString("nombre_lista"));
                // Simplificación, se recomienda deserializar adecuadamente
                lista.setCanciones(new ArrayList<>());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}