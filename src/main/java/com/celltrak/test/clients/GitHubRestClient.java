package com.celltrak.test.clients;

import com.celltrak.test.api.GitHubRepositoryInfoDTO;
import com.celltrak.test.utils.PropertyUtils;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * GitHub Rest Client.
 *
 * @author alexis.alvarez
 */
public class GitHubRestClient extends Service {
    public static final Logger LOGGER = Logger.getLogger(GitHubRestClient.class);

    private Properties properties = new Properties();
    private String baseUri;

    public GitHubRestClient() throws IOException {
        this.properties = PropertyUtils
                .readProperty("com/celltrak/test/clients/github.properties", properties, this.getClass());
        this.baseUri = this.properties.getProperty("github.host");
    }

    /**
     * Method to get Repositories information given an author username.
     *
     * @param username username
     * @return a list of GitHubRepositoryInfoDTO objects
     * @throws IOException if the rest-service fails
     */
    public GitHubRepositoryInfoDTO[] getReposInformation(String username)
            throws Exception {
        try {
            LOGGER.info("Getting Repos information...");
            String serviceUrl = "/".concat(username).concat(this.properties.getProperty("repos.url"));

            String json = RestAssured.given().baseUri(baseUri)
                    .get(serviceUrl)
                    .then().statusCode(200)
                    .contentType(ContentType.JSON).extract().response().asString();
            return this.getJsonMapper().readValue(json, GitHubRepositoryInfoDTO[].class);
        } catch (Exception ex) {
            throw new Exception("There is a problem getting results in GitHub. Error :" + ex);
        }
    }

    /**
     * Method to get Repositories information given an author username, page and size per page.
     *
     * @param username    username
     * @param page        page number
     * @param sizePerPage size per page
     * @return a list of GitHubRepositoryInfoDTO objects
     * @throws IOException if the rest-service fails
     */
    public GitHubRepositoryInfoDTO[] getReposPaginationInformation(String username, int page, int sizePerPage)
            throws IOException {
        LOGGER.info("Getting Repos information with pagination...");
        String serviceUrl = "/".concat(username).concat(buildUrl(this.properties.getProperty("pagination.url"), page, sizePerPage));

        String json = RestAssured.given().baseUri(baseUri)
                .get(serviceUrl)
                .then().statusCode(200)
                .contentType(ContentType.JSON).extract().response().asString();
        return this.getJsonMapper().readValue(json, GitHubRepositoryInfoDTO[].class);
    }

}
