package ge.shuangyang;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author geshuangyang
 * @date 2025/09/02
 */
public class IntensitySegmentsTests {


    @Test
    public void checkAddIntensitySegments() {
        IntensitySegments segments = new IntensitySegments();
        System.out.println(segments);
        Assert.assertEquals("[]", segments.toString());

        segments.add(10, 30, 1);
        System.out.println(segments);
        Assert.assertEquals("[[10,1][30,0]]", segments.toString());
        segments.add(20, 40, 1);
        System.out.println(segments);
        Assert.assertEquals("[[10,1][20,2][30,1][40,0]]", segments.toString());

        segments.add(10, 40, -2);
        System.out.println(segments);
        Assert.assertEquals("[[10,-1][20,0][30,-1][40,0]]", segments.toString());

    }

    @Test
    public void checkAnotherAddIntensitySegments() {
        IntensitySegments segments = new IntensitySegments();
        System.out.println(segments);
        Assert.assertEquals("[]", segments.toString());

        segments.add(10, 30, 1);
        System.out.println(segments);
        Assert.assertEquals("[[10,1][30,0]]", segments.toString());
        segments.add(20, 40, 1);
        System.out.println(segments);
        Assert.assertEquals("[[10,1][20,2][30,1][40,0]]", segments.toString());

        segments.add(10, 40, -1);
        System.out.println(segments);
        Assert.assertEquals("[[20,1][30,0]]", segments.toString());

        segments.add(10, 40, -1);
        System.out.println(segments);
        Assert.assertEquals("[[10,-1][20,0][30,-1][40,0]]", segments.toString());

    }

    @Test
    public void checkSetIntensitySegments() {
        IntensitySegments segments = new IntensitySegments();
        System.out.println(segments);
        Assert.assertEquals("[]", segments.toString());

        segments.add(10, 30, 1);
        System.out.println(segments);
        Assert.assertEquals("[[10,1][30,0]]", segments.toString());
        segments.set(20, 40, 1);
        System.out.println(segments);
        Assert.assertEquals("[[10,1][20,1][30,1][40,0]]", segments.toString());

        segments.set(10, 40, -2);
        System.out.println(segments);
        Assert.assertEquals("[[10,-2][20,-2][30,-2][40,0]]", segments.toString());

    }

}
