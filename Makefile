DEFAULT_GOAL := build-run

run-smallstylish:
	./app/build/install/app/bin/app --format=stylish /home/newcomer/java-project-71/app/src/test/resources/f1.json app/src/test/resources/f2.json

run-bigstylish:
	./app/build/install/app/bin/app --format=stylish /home/newcomer/java-project-71/app/src/test/resources/file_1.json app/src/test/resources/file_2.json

run-smalldefault:
	./app/build/install/app/bin/app /home/newcomer/java-project-71/app/src/test/resources/f1.json app/src/test/resources/f2.json

run-help:
	./app/build/install/app/bin/app -h

run-vers:
	./app/build/install/app/bin/app -V

run-dist:
	./app/build/install/app/bin/app --format stylish /home/newcomer/java-project-71/app/src/main/resources/f1.json app/src/main/resources/f2.json

run-yaml:
	./app/build/install/app/bin/app --format yaml /home/newcomer/java-project-71/app/src/test/resources/file1.yml app/src/test/resources/file2.yml

run-json:
	./app/build/install/app/bin/app --format json /home/newcomer/java-project-71/app/src/test/resources/file_1.json app/src/test/resources/file_2.json

run-build:
	./app/gradlew -p app clean build

run-test:
	./app/gradlew -p app test

run-report:
	./app/gradlew -p app jacocoTestReport

.PHONY: build
