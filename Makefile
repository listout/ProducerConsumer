java = javac
jvm = java
jflags = -d
cp = ClassFiles

default: build

build: $(wildcard $(cp)/*.class) check_cp
	$(java) $(jflags) $(cp) Conzooming.java

run:
ifeq (, $(wildcard $(cp)/*.class))
	@echo "run build first"
else
	$(jvm) -cp $(cp) Conzooming
endif

check_cp:
	mkdir -p $(cp)

clean:
	rm -fr $(cp)
