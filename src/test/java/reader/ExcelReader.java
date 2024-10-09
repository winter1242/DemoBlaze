package reader;

import com.poiji.bind.Poiji;
import modelos.Producto;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private final static String excelPath = "src/test/resources/excel/DATA.xlsx";

    public static List<Producto> obtenerListaProducto() {
        return Poiji.fromExcel(new File(excelPath), Producto.class);
    }
}
