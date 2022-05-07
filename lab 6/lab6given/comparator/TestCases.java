import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

public class TestCases
{
   private static final Song[] songs = new Song[] {
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005),
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Gerry Rafferty", "Baker Street", 1978)
      };

   @Test
   public void testArtistComparator()
   {
      Comparator<Song> test = new ArtistComparator();
      assertTrue(test.compare(songs[0],songs[1])<0);
      assertTrue(test.compare(songs[1],songs[0])>0);
      assertTrue(test.compare(songs[0],songs[0])==0);
      assertTrue(test.compare(songs[2],songs[6])<0);
      assertTrue(test.compare(songs[6],songs[2])>0);

//      assertFalse(test.compare(songs[2],songs[6])>0);

   }

   @Test
   public void testLambdaTitleComparator()
   {
      Comparator <Song> compTitle= (s1, s2)-> s1.getTitle().compareTo(s2.getTitle());

      assertTrue(compTitle.compare(songs[2],songs[7])>0);
      assertTrue(compTitle.compare(songs[3],songs[7])==0);
      assertTrue(compTitle.compare(songs[1],songs[0])<0);

   }

   @Test
   public void testYearExtractorComparator()
   {
      Comparator<Song> compYear = Comparator.comparing(Song::getYear, (s1,s2) -> s2.compareTo(s1));

      assertTrue(compYear.compare(songs[2],songs[7])<0);
      assertTrue(compYear.compare(songs[7],songs[6])<0);
      assertEquals(compYear.compare(songs[0],songs[1]),0);
   }

   @Test
   public void testComposedComparator()
   {
      Comparator<Song> compYear = Comparator.comparing(Song::getYear, (s1,s2) -> s2.compareTo(s1));
      Comparator <Song> compTitle = (s1, s2)-> s1.getTitle().compareTo(s2.getTitle());

      Comparator <Song> yearThenTital = new ComposedComparator(compYear, compTitle);

      assertTrue(yearThenTital.compare(songs[2],songs[7])<0);
      assertTrue(yearThenTital.compare(songs[7],songs[6])<0);
      assertTrue(yearThenTital.compare(songs[0],songs[1])>0);


   }

   @Test
   public void testThenComparing()
   {
      Comparator<Song> titleThenArtist = Comparator.comparing(Song::getTitle, (s1,s2) -> s1.compareTo(s2)).thenComparing(new ArtistComparator());



      assertTrue(titleThenArtist.compare(songs[2],songs[7])>0);
      assertTrue(titleThenArtist.compare(songs[7],songs[6])<0);
      assertTrue(titleThenArtist.compare(songs[3],songs[5])>0);

   }

   @Test
   public void runSort()
   {
      Comparator<Song> CompareAllTheThings = Comparator.comparing(Song::getArtist, (s1,s2) -> s1.compareTo(s2))
              .thenComparing(Song::getTitle, (s1,s2) -> s1.compareTo(s2))
              .thenComparing(Song::getYear, (s1,s2) -> s1.compareTo(s2));

      List<Song> songList = new ArrayList<>(Arrays.asList(songs));
      List<Song> expectedList = Arrays.asList(
         new Song("Avett Brothers", "Talk on Indolence", 2006),
         new Song("City and Colour", "Sleeping Sickness", 2007),
         new Song("Decemberists", "The Mariner's Revenge Song", 2005),
         new Song("Foo Fighters", "Baker Street", 1997),
         new Song("Gerry Rafferty", "Baker Street", 1978),
         new Song("Gerry Rafferty", "Baker Street", 1998),
         new Song("Queen", "Bohemian Rhapsody", 1975),
         new Song("Rogue Wave", "Love's Lost Guarantee", 2005)
         );

      songList.sort(CompareAllTheThings);

      assertEquals(songList, expectedList);
   }
}
