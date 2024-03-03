package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider(name = "dataForDivPosInt", parallel = true)
    public static Object[][] dataForDivPosIntTest() {
        return new Object[][]{
                {-6, -2, 3.0},
                {3, 2, 1.0},
                {-99, 2, -49.0}
        };
    }

    @DataProvider(name = "dataForDivNegInt", parallel = true)
    public static Object[][] dataForDivNegIntTest() {
        return new Object[][]{
                {-6, 0, 0.0},
                {2, 0, 0.0},
                {0, 0, 0.0}
        };
    }

    @DataProvider(name = "dataForDivPosDouble", parallel = true)
    public static Object[][] dataForDivPosDoubleTest() {
        return new Object[][]{
                {-6.6, -2.1, 3.1428571428571423},
                {3.4, 1.5, 2.2666666666666666},
                {-99.5, 33.6, -2.9613095238095237}
        };
    }

    @DataProvider(name = "dataForDivNegDouble", parallel = true)
    public static Object[][] dataForDivNegIntDouble() {
        return new Object[][]{
                {-6.2, 0.0, Double.NEGATIVE_INFINITY},
                {2.9, 0.0, Double.POSITIVE_INFINITY},
                {0.0, 0.0, Double.NaN}
        };
    }


    @DataProvider(name = "dataForDivPosIntByDouble", parallel = true)
    public static Object[][] dataForDivPosIntByDoubleTest() {
        return new Object[][]{
                {1, -2.1, -0.47619047619047616},
                {5000, 1.5, 3333.3333333333335},
                {7, 33.6, 0.20833333333333331}
        };
    }

    @DataProvider(name = "dataForDivPosDoubleByInt", parallel = true)
    public static Object[][] dataForDivPosDoubleByIntTest() {
        return new Object[][]{
                {-45.345689, -2, 22.6728445},
                {5000.303849404, 300, 16.667679498013335},
                {34.234950, -33, -1.0374227272727272}
        };
    }

}
