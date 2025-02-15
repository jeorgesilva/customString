package customstring;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomStringTest {

    private CustomString myCustomString;

    @BeforeEach
    public void setUp() {
        this.myCustomString = new CustomString();
    }

    @Test
    void testGetString() {
        assertNull(this.myCustomString.getString());

        this.myCustomString.setString("hello");
        assertEquals("hello", this.myCustomString.getString());

        this.myCustomString.setString("");
        assertEquals("", this.myCustomString.getString());

        this.myCustomString.setString("!@#$%^&*()");
        assertEquals("!@#$%^&*()", this.myCustomString.getString());

        this.myCustomString.setString(null);
        assertNull(this.myCustomString.getString());
    }

    @Test
    void testSetString() {
        assertNull(this.myCustomString.getString());

        this.myCustomString.setString("Good-bye!");
        assertEquals("Good-bye!", this.myCustomString.getString());

        this.myCustomString.setString(null);
        assertNull(this.myCustomString.getString());

        this.myCustomString.setString("");
        assertEquals("", this.myCustomString.getString());

        this.myCustomString.setString("   ");
        assertEquals("   ", this.myCustomString.getString());
    }

    @Test
    void testRemove() {
        assertEquals("", this.myCustomString.remove(""));

        this.myCustomString.setString(null);
        assertEquals("", this.myCustomString.remove(""));

        this.myCustomString.setString("my lucky numbers are 6, 8, and 19.");
        assertEquals("my lucky numbes e 6, 8, nd 19.", this.myCustomString.remove("ra6"));

        this.myCustomString.setString("hello world");
        assertEquals("hello world", this.myCustomString.remove(""));

        this.myCustomString.setString("hello!@# world");
        assertEquals("hello!@# world", this.myCustomString.remove("!@#"));

        this.myCustomString.setString("Hello World");
        assertEquals("Heo Word", this.myCustomString.remove("lw"));
    }

    @Test
    void testReverse() {
        assertEquals("", this.myCustomString.reverse(""));

        this.myCustomString.setString(null);
        assertEquals("", this.myCustomString.reverse(""));

        this.myCustomString.setString("abc, XYZ; 123.");
        assertEquals("aBC, xyz; 123.", this.myCustomString.reverse("bcdxyz@3210."));

        this.myCustomString.setString("Hello World");
        assertEquals("Hello World", this.myCustomString.reverse(""));

        this.myCustomString.setString("Hello!@# World");
        assertEquals("Hello!@# World", this.myCustomString.reverse("!@#"));

        this.myCustomString.setString("Hello World");
        assertEquals("hELLO wORLD", this.myCustomString.reverse("helo"));
    }

    @Test
    void testFilterLetters() {
        assertEquals("", this.myCustomString.filterLetters('E', false));

        this.myCustomString.setString(null);
        assertEquals("", this.myCustomString.filterLetters('E', false));

        this.myCustomString.setString("Hello 123 World");
        assertEquals("He 123 Word", this.myCustomString.filterLetters('l', false));

        this.myCustomString.setString("Hello 123 World");
        assertEquals("llo 123 orld", this.myCustomString.filterLetters('H', true));

        this.myCustomString.setString("Abcdefg");
        assertEquals("defg", this.myCustomString.filterLetters('c', false));

        this.myCustomString.setString("Abcdefg");
        assertEquals("Ab", this.myCustomString.filterLetters('c', true));
    }
}
