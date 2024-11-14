package implementacion;

import java.util.HashMap;
import java.util.Map;

public class FabricaCanciones {
    public static boolean HabilitarFlyweight = true;
    private static final Map<String, Cancion> PLAY_CANCION = new HashMap<>();
    private static Long Secuencia = 0L;

    public static Cancion CrearItem(String NombreTema, Artista artista) {
        if (HabilitarFlyweight && PLAY_CANCION.containsKey(NombreTema)) {
            return PLAY_CANCION.get(NombreTema);
        } else {
            Cancion playItem = new Cancion(++Secuencia, NombreTema, artista);
            PLAY_CANCION.put(NombreTema, playItem);
            return playItem;
        }
    }
}