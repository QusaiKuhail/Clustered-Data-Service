# Variables
DOCKER_IMAGE_NAME := your-docker-image-name
DOCKER_CONTAINER_NAME := your-docker-container-name
DOCKER_PORT := 8080

# Build the application
build:
	mvn clean package

# Run unit tests
test:
	mvn test

# Build the Docker image
docker-build:
	docker build -t $(DOCKER_IMAGE_NAME) .

# Run the application using Docker
docker-run:
	docker run -d -p $(DOCKER_PORT):8080 --name $(DOCKER_CONTAINER_NAME) $(DOCKER_IMAGE_NAME)

# Stop and remove the Docker container
docker-stop:
	docker stop $(DOCKER_CONTAINER_NAME)
	docker rm $(DOCKER_CONTAINER_NAME)
