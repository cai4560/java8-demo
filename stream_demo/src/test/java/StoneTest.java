import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoneTest {
    private List<Stone> stoneList;

    @Before
    public void setUp() {
        stoneList = prepareStoneData();
    }

    @Test
    public void should_filter_and_sort_by_requirement_with_collection_operation() {
        List<Stone> orderedStoneList = new ArrayList<>();

        for (Stone stone : this.stoneList) {
            if (stone.getWeight() > 500) {
                orderedStoneList.add(stone);
            }
        }

        Collections.sort(orderedStoneList, new Comparator<Stone>() {
            @Override
            public int compare(Stone firstStone, Stone secondStone) {
                return Double.compare(firstStone.getWeight(), secondStone.getWeight());
            }
        });

        List<String> orderStoneColorList = new ArrayList<>();
        for (Stone stone : orderedStoneList) {
            orderStoneColorList.add(stone.getColor());
        }

        assertStoneOrder(orderStoneColorList);
    }

    @Test
    public void should_filter_and_sort_by_requirement_with_stream() {
        List<String> orderStoneColorList = stoneList.stream()
                .filter(stone -> stone.getWeight() > 500)
                .sorted(Comparator.comparing(Stone::getWeight))
                .map(Stone::getColor)
                .collect(Collectors.toList());

        assertStoneOrder(orderStoneColorList);
    }

    private List<Stone> prepareStoneData() {
        List<Stone> prepareStoneList = new ArrayList<>();

        prepareStoneList.add(new Stone("blue", 800d));
        prepareStoneList.add(new Stone("black", 1200d));
        prepareStoneList.add(new Stone("green", 400d));
        prepareStoneList.add(new Stone("red", 600d));
        prepareStoneList.add(new Stone("yellow", 300d));

        return prepareStoneList;
    }

    private void assertStoneOrder(List<String> stoneColorList) {
        assertThat(stoneColorList.get(0), is("red"));
        assertThat(stoneColorList.get(1), is("blue"));
        assertThat(stoneColorList.get(2), is("black"));
    }
}