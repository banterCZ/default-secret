# Default Secret with Spring Boot

This project should demonstrate the configuration of the secret needed for development but not disclose the default to production.

A blog post describing the use case is published in Czech at https://blog.zvestov.cz/software%20development/2023/09/14/vychozi-zabezpeceni.html

## Run

The first run should fail because missing all configurations.

For development purposes, activate the spring profile `dev`.
It generates a random value.
It is different for each application start.

For production configuration, enable implementation to read the secret from a file and specify the file path.
The first line of the file should contain a base64 encoded secret.

```properties
cz.zvestov.secret.type=file
#TODO path to your file with the secret
cz.zvestov.secret.file.path=
```
