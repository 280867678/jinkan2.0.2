package me.tvspark;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* renamed from: me.tvspark.l9 */
/* loaded from: classes4.dex */
public final class C2325l9 {
    @VisibleForTesting
    public static final String[] Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    @Nullable
    public static C2403nd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, C2078el c2078el) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1684108385) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
            return new C2403nd(str, null, c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww - 16));
        }
        String valueOf = String.valueOf(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        if (valueOf.length() != 0) {
            "Failed to parse text attribute: ".concat(valueOf);
        } else {
            new String("Failed to parse text attribute: ");
        }
        return null;
    }

    public static int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(C2078el c2078el) {
        c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(4);
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1684108385) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(8);
            return c2078el.Wwwwwwwwwwwwwwwwwwwwww();
        }
        return -1;
    }

    @Nullable
    public static AbstractC2255jd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, C2078el c2078el, boolean z, boolean z2) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(c2078el);
        if (z2) {
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = Math.min(1, Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2);
        }
        if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 >= 0) {
            return z ? new C2403nd(str, null, Integer.toString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2)) : new C2144gd("und", str, Integer.toString(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2));
        }
        String valueOf = String.valueOf(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        if (valueOf.length() != 0) {
            "Failed to parse uint8 attribute: ".concat(valueOf);
        } else {
            new String("Failed to parse uint8 attribute: ");
        }
        return null;
    }

    @Nullable
    public static C2403nd Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(int i, String str, C2078el c2078el) {
        int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww();
        if (c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() == 1684108385 && Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww >= 22) {
            c2078el.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(10);
            int Wwwwwwwwwwwwwwwww = c2078el.Wwwwwwwwwwwwwwwww();
            if (Wwwwwwwwwwwwwwwww > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(Wwwwwwwwwwwwwwwww);
                String sb2 = sb.toString();
                int Wwwwwwwwwwwwwwwww2 = c2078el.Wwwwwwwwwwwwwwwww();
                if (Wwwwwwwwwwwwwwwww2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(Wwwwwwwwwwwwwwwww2);
                    sb2 = sb3.toString();
                }
                return new C2403nd(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(AbstractC2140g9.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(i));
        if (valueOf2.length() != 0) {
            "Failed to parse index/count attribute: ".concat(valueOf2);
        } else {
            new String("Failed to parse index/count attribute: ");
        }
        return null;
    }
}
