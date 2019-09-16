package com.celltrak.test.tests;

import com.celltrak.test.api.GitHubRepositoryInfoDTO;
import com.celltrak.test.clients.GitHubRestClient;
import com.celltrak.test.configuration.DataProviderTest;
import com.celltrak.test.dto.InputDTO;
import com.celltrak.test.utils.UtilMethods;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Test class.
 * @author alexis.alvarez
 */
public class ExampleTest {
    private static final Logger LOGGER = Logger.getLogger(ExampleTest.class.getName());
    GitHubRestClient gitHubRestClient = new GitHubRestClient();

    public ExampleTest() throws IOException {
    }

    @Test(
            description = "Rest Service Github test - By Author",
            dataProvider = "test",
            dataProviderClass = DataProviderTest.class,
            groups = {"testExample", "smoke"}
    )
    @Severity(SeverityLevel.MINOR)
    public void testRepos(InputDTO inputData) throws Exception {
        GitHubRepositoryInfoDTO[] gitHubRepositoryInfoDTOS = gitHubRestClient.getReposInformation(inputData.getUsername());
        Assertions.assertThat(
                gitHubRepositoryInfoDTOS.length).isGreaterThan(0);
        LOGGER.info("There are repositories for user : ".concat(inputData.getUsername()).concat("!"));

        GitHubRepositoryInfoDTO gitHubRepositoryInfoDTO = gitHubRepositoryInfoDTOS[UtilMethods.getRandomNumberInRange(0, gitHubRepositoryInfoDTOS.length - 1)];

        Assertions.assertThat(
                gitHubRepositoryInfoDTO.getFull_name()).isNotNull();
        Assertions.assertThat(
                gitHubRepositoryInfoDTO.getHtml_url()).contains("http");
        Assertions.assertThat(
                gitHubRepositoryInfoDTO.getId()).isGreaterThan(0);
        Assertions.assertThat(
                gitHubRepositoryInfoDTO.getOwner()).isNotNull();

        Assertions.assertThat(
                gitHubRepositoryInfoDTO.getOwner().getAvatar_url()).contains("http");
        Assertions.assertThat(
                gitHubRepositoryInfoDTO.getId()).isGreaterThan(0);
        Assertions.assertThat(
                gitHubRepositoryInfoDTO.getOwner().getLogin()).isNotEmpty();
        Assertions.assertThat(
                gitHubRepositoryInfoDTO.getOwner().getType()).isNotEmpty();

        LOGGER.info("All the asserts for user : ".concat(inputData.getUsername()).concat(" were success!"));
    }

    @Test(
            description = "Rest Service Github test - By Author using Pagination",
            dataProvider = "test",
            dataProviderClass = DataProviderTest.class,
            groups = {"testExample"}
    )
    @Severity(SeverityLevel.BLOCKER)
    public void testPagination(InputDTO inputData) throws Exception {
        GitHubRepositoryInfoDTO[] gitHubRepositoryInfoDTOS = gitHubRestClient.getReposPaginationInformation(inputData.getUsername(), inputData.getPage(), inputData.getSize());
        Assertions.assertThat(
                gitHubRepositoryInfoDTOS.length).isGreaterThan(0);
        LOGGER.info("There are repositories for user : ".concat(inputData.getUsername()).concat(" in page : ").
                concat(String.valueOf(inputData.getPage())).concat(" in size : ").concat(String.valueOf(inputData.getSize())));
        Assertions.assertThat(
                gitHubRepositoryInfoDTOS.length).isBetween(1, 10);

        LOGGER.info("All the asserts for user : ".concat(inputData.getUsername()).concat(" were success!"));
    }

    @Test(
            description = "Rest Service Github test - By Author using Pagination. Comparing information between pages",
            dataProvider = "test",
            dataProviderClass = DataProviderTest.class,
            groups = {"testExample"}
    )
    @Severity(SeverityLevel.NORMAL)
    public void testPaginationDifferentData(InputDTO inputData) throws Exception {
        GitHubRepositoryInfoDTO[] gitHubRepositoryInfoDTOS = gitHubRestClient.getReposPaginationInformation(inputData.getUsername(), 1, 5);
        Assertions.assertThat(
                gitHubRepositoryInfoDTOS.length).isGreaterThan(0);
        LOGGER.info("There are repositories for user : ".concat(inputData.getUsername()).concat(" in page : ").
                concat(String.valueOf(inputData.getPage())).concat(" in size : ").concat(String.valueOf(inputData.getSize())));
        int firstPageIdFirstRepository = gitHubRepositoryInfoDTOS[0].getId();

        GitHubRepositoryInfoDTO[] gitHubRepositoryInfoDTOSSecondPage = gitHubRestClient.getReposPaginationInformation(inputData.getUsername(), 2, 5);
        int secondPageIdFirstRepository = gitHubRepositoryInfoDTOSSecondPage[0].getId();

        Assertions.assertThat(firstPageIdFirstRepository).isNotEqualTo(secondPageIdFirstRepository);

        LOGGER.info("All the asserts for user : ".concat(inputData.getUsername()).concat(" were success!"));
    }

    @Test(
            description = "Rest Service Github test - By Author. Negative TestCase : user not exists",
            dataProvider = "negativeTest",
            dataProviderClass = DataProviderTest.class,
            groups = {"testExample", "smoke"}
    )
    @Severity(SeverityLevel.NORMAL)
    public void negativeTestUserNotExists(InputDTO inputData) throws Exception {
        GitHubRepositoryInfoDTO[] gitHubRepositoryInfoDTOS = gitHubRestClient.getReposInformation(inputData.getUsername());
        Assertions.assertThat(
                gitHubRepositoryInfoDTOS.length).isEqualTo(0);
        LOGGER.info("There are no repositories for user : ".concat(inputData.getUsername()).concat(" as expected!"));
    }

    @Test(
            description = "Rest Service Github test - By Author. Negative TestCase : no repositories for given page",
            dataProvider = "negativeTestPagination",
            dataProviderClass = DataProviderTest.class,
            groups = {"testExample", "regression"}
    )
    @Severity(SeverityLevel.CRITICAL)
    public void negativeTestPaginationWithNoResults(InputDTO inputData) throws Exception {
        GitHubRepositoryInfoDTO[] gitHubRepositoryInfoDTOS = gitHubRestClient.getReposPaginationInformation(inputData.getUsername(), inputData.getPage(), inputData.getSize());
        Assertions.assertThat(
                gitHubRepositoryInfoDTOS.length).isEqualTo(0);
        LOGGER.info("There are no repositories for user : ".concat(inputData.getUsername()).concat(" on page ").
                concat(String.valueOf(inputData.getPage()).concat(" for size : ").
                        concat(String.valueOf(inputData.getSize())).concat(" as expected!")));
    }
}
