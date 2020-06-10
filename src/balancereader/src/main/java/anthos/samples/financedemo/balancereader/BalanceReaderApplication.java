/*
 * Copyright 2020, Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package anthos.samples.financedemo.balancereader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the BalanceReader Spring Boot application.
 *
 * Microservice to track the bank balance for each user account.
 */
@SpringBootApplication
public class BalanceReaderApplication {

    private static final Logger LOGGER =
        LogManager.getLogger(BalanceReaderApplication.class);

    private static final String[] EXPECTED_ENV_VARS = {
        "VERSION",
        "PORT",
        "LOCAL_ROUTING_NUM",
        "PUB_KEY_PATH",
        "SPRING_DATASOURCE_URL",
        "SPRING_DATASOURCE_USERNAME",
        "SPRING_DATASOURCE_PASSWORD",
        "LOG_LEVEL"
    };

    public static void main(String[] args) {
        // Check that all required environment variables are set.
        for (String v : EXPECTED_ENV_VARS) {
            String value = System.getenv(v);
            if (value == null) {
                LOGGER.error(String.format(
                    "error: %s environment variable not set", v));
                System.exit(1);
            }
        }
        SpringApplication.run(BalanceReaderApplication.class, args);
        LOGGER.info("Started BalanceReader service.");
    }
}
