package linear;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class GaussianEliminationStructureTest {
    static CheckThat it;
    
    @BeforeAll
    public static void init() {
        it = CheckThat.theClass("linear.algebra.GaussianElimination")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldRows() {
        it.hasFieldOfType("rows", "int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void fieldCols() {
        it.hasFieldOfType("cols", "int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void fieldMatrix() {
        it.hasFieldOfType("matrix", double[][].class.getName())
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructorWithParams("int", "int", double[][].class.getName())
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodArgMax() {
        it.hasMethodWithParams("argMax", "int", "int")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturns("int");
    }

    @Test
    public void methodBackSubstitution() {
        it.hasMethodWithNoParams("backSubstitution")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodCheckMatrixDimensions() {
        it.hasMethodWithParams("checkMatrixDimensions", double[][].class.getName())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodMultiplyAndAddRow() {
        it.hasMethodWithParams("multiplyAndAddRow", "int", "int", "int")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodMultiplyRow() {
        it.hasMethodWithParams("multiplyRow", "int", "int")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodPrint() {
        it.hasMethodWithNoParams("print")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodRowEchelonForm() {
        it.hasMethodWithNoParams("rowEchelonForm")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodSwapRows() {
        it.hasMethodWithParams("swapRows", "int", "int")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }
}