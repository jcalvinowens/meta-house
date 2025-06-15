CC ?= cc
CFLAGS ?= -Oz
BASE_CFLAGS = -std=c11 -pedantic -nostdlib
CFLAGS += $(BASE_CFLAGS)

WFLAGS = -Werror -Wall -Wextra -Wno-switch -Wdeclaration-after-statement \
	 -Wduplicated-cond -Wduplicated-branches -Wlogical-op -Wrestrict \
	 -Wnull-dereference -Wjump-misses-init -Wdouble-promotion -Wshadow \
	 -Wformat=2 -Wstrict-aliasing -Wno-unknown-warning-option \
	 -Wno-format-nonliteral -Wpedantic

all: init

init: init.o
	$(CC) -o $@ $^ $(CFLAGS) $(LDFLAGS)

%.o: %.c
	$(CC) $< $(CFLAGS) $(WFLAGS) -c -o $@

%.s: %.c
	$(CC) $< $(CFLAGS) -fverbose-asm $(WFLAGS) -S -c -o $@

%.o: %.s
	$(CC) $< -c -o $@

clean:
	rm -f *.o *.s init
