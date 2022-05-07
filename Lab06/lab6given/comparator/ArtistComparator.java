import java.util.Comparator;

public class ArtistComparator implements Comparator<Song> {

    
    public int compare(Song a, Song b){

        return a.getArtist().compareTo(b.getArtist());

    }
}
