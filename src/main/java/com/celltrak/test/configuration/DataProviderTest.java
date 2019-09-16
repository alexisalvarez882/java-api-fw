package com.celltrak.test.configuration;


import com.celltrak.test.dto.InputDTO;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/**
 * Class that contains all the dataproviders for the tests.
 *
 * @author alexis.alvarez
 */
public class DataProviderTest {

  @DataProvider(name = "test")
  public Iterator<InputDTO> provider() throws InterruptedException, IOException {
    List<InputDTO> inp = getIterator("data.csv");
    return inp.iterator();
  }

  @DataProvider(name = "negativeTest")
  public Iterator<InputDTO> negativeProvider() throws InterruptedException, IOException {
    List<InputDTO> inp = getIterator("negativedata.csv");
    return inp.iterator();
  }

  @DataProvider(name = "negativeTestPagination")
  public Iterator<InputDTO> negativeProviderPagination() throws InterruptedException, IOException {
    List<InputDTO> inp = getIterator("negativedatapagination.csv");
    return inp.iterator();
  }

  private List<InputDTO> getIterator(String fileName) throws IOException {
    URL resource = this.getClass().getResource("/com/celltrak/test/testdata/");
    File csvFile = new File(resource.getPath().concat(fileName));
    MappingIterator<InputDTO> testIter = new CsvMapper()
            .readerWithTypedSchemaFor(InputDTO.class).readValues(csvFile);
    return testIter.readAll();
  }

}
