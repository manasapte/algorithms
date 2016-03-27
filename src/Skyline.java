import java.util.*;

enum Terminal {
    START, END
}

class BuildingPoint implements Comparable<BuildingPoint> {
    int x;
    int y;
    Terminal term;

    BuildingPoint(int x, int y, Terminal term) {
        this.x = x;
        this.y = y;
        this.term = term;
    }

    public int compareTo(BuildingPoint that) {
        if(this.x != that.x) {
            return this.x - that.x;
        }
        if(this.term == Terminal.START && that.term == Terminal.START) {
            return that.y - this.y;
        }
        if(this.term == Terminal.END && that.term == Terminal.END) {
            return this.y - that.y;
        }
        if(this.term == Terminal.START) {
            return -1;
        }
        return 1;
    }
}
public class Skyline {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        Map<Integer, BuildingPoint> queue = new TreeMap<Integer, BuildingPoint>();
        BuildingPoint[] buildingPoints = new BuildingPoint[2 * buildings.length];
        for(int i=0; i < buildings.length; i++) {
            for(int j=0; j<3; j++) {
                int[] coords = buildings[i];
                BuildingPoint start = new BuildingPoint(coords[0], coords[2], Terminal.START);
                BuildingPoint end = new BuildingPoint(coords[1], coords[2], Terminal.END);
                buildingPoints[2*i] = start;
                buildingPoints[2*i + 1] = end;
            }
        }
        Arrays.sort(buildingPoints);
        for(int i=0; i<buildingPoints.length; i++) {

        }
        return null;
    }

    public static void main(String[] args) {

    }
}
