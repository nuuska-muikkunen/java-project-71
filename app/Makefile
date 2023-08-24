DEFAULT_GOAL := build-run

run-old:
	./build/install/app/bin/app --format=stylish /home/newcomer/java-project-71/app/src/main/resources/f1.json src/main/resources/f2.json

run-default:
	./build/install/app/bin/app /home/newcomer/java-project-71/app/src/main/resources/f1.json src/main/resources/f2.json

run-help:
	./build/install/app/bin/app -h

run-vers:
	./build/install/app/bin/app -V

run-dist:
	./build/install/app/bin/app --format stylish /home/newcomer/java-project-71/app/src/main/resources/f1.json src/main/resources/f2.json

run-yaml:
	./build/install/app/bin/app --format yaml /home/newcomer/java-project-71/app/src/main/resources/f1.yaml src/main/resources/f2.yaml

run-build:
	./gradlew clean build

run-test:
	./gradlew test

report:
	./gradlew jacocoTestReport

.PHONY: build
