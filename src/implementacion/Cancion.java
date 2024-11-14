package implementacion;

public class Cancion {
    private Long id;
    private String NombreCancion;
    private byte[] Cancion = new byte[1000000];
    private Artista artista;

    public Cancion(Long id, String NombreCancion, Artista artista) {
        this.id = id;
        this.NombreCancion = NombreCancion;
        this.artista = artista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return NombreCancion;
    }

    public void setNombreCancion(String NombreCancion) {
        this.NombreCancion = NombreCancion;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Cancion{" + "id=" + id + ", NombreCancion='" + NombreCancion + '\'' + ", artista=" + artista + '}';
    }
}