/*
 * Copyright (C) 2025 Calvin Owens <calvin@wbinvd.org>
 *
 * Permission to use, copy, modify, and /or distribute this software for
 * any purpose with or without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

#include <asm/unistd_64.h>

static inline long syscall(long __nr, long __a1, long __a2, long __a3,
			   long __a4, long __a5, long __a6)
{
	#if defined(__x86_64__)
	register long nr __asm__ ("rax") = __nr;
	register long a1 __asm__ ("rdi") = __a1;
	register long a2 __asm__ ("rsi") = __a2;
	register long a3 __asm__ ("rdx") = __a3;
	register long a4 __asm__ ("r10") = __a4;
	register long a5 __asm__ ("r8") = __a5;
	register long a6 __asm__ ("r9") = __a6;
	__asm__ volatile ("syscall" : "+r" (nr) : "r" (nr), "r" (a1), "r" (a2),
			  "r" (a3), "r" (a4), "r" (a5), "r" (a6) :
			  "memory", "cc", "rcx", "r11");
	return nr;
	#else
	#error "Please implement syscall() for this architecture"
	#endif
}

void _start(void)
{
	static const char msg[] = "Hello initrd world!\n";
	syscall(__NR_write, 1, (long)(void *)msg, sizeof(msg) - 1, 0, 0, 0);
	syscall(__NR_exit, 0, 0, 0, 0, 0, 0);
}
