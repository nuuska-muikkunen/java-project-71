DEFAULT_GOAL := build-run

run-old:
	./app/build/install/app/bin/app --format=stylish /home/newcomer/java-project-71/app/src/main/resources/f1.json src/main/resources/f2.json

run-mix:
	./app/build/install/app/bin/app --format=stylish /home/newcomer/java-project-71/app/src/test/resources/file_1.json src/test/resources/file_2.json

run-default:
	./app/build/install/app/bin/app /home/newcomer/java-project-71/app/src/main/resources/f1.json src/main/resources/f2.json

run-help:
	./app/build/install/app/bin/app -h

run-vers:
	./app/build/install/app/bin/app -V

run-dist:
	./app/build/install/app/bin/app --format stylish /home/newcomer/java-project-71/app/src/main/resources/f1.json src/main/resources/f2.json

run-yaml:
	./app/build/install/app/bin/app --format yaml /home/newcomer/java-project-71/app/src/main/resources/f1.yaml src/main/resources/f2.yaml

run-build:
	./app/gradlew clean build

run-test:
	./app/gradlew test

report:
	./app/gradlew jacocoTestReport

.PHONY: build
