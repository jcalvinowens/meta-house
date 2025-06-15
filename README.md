# House Linux

Build a Linux desktop from scratch with Yocto.

## Quick Build

Follow instructions for setting up Yocto [here](https://docs.yoctoproject.org/dev-manual/start.html#preparing-the-build-host) and [here](https://docs.yoctoproject.org/ref-manual/system-requirements.html#required-packages-for-the-build-host).

```
git clone https://github.com/jcalvinowens/meta-house
cd meta-house
kas build
```

The full build of all images takes 6-8 hours on a typical desktop computer
suitable for modern video games. It will take multiple days on a laptop. It's
Chromium in the desktop images that makes it so slow: Chromium alone takes more
than twice as long to build as the cross toolchain and rest of the system
combined.

If you only want one image, you can specify it on the command line:

```
kas build --target=mc:house:desktop-workstation-image
kas build --target=mc:house:desktop-image
kas build --target=mc:house:workstation-image
kas build --target=mc:house:minimal-image
kas build --target=mc:garage:workstation-image
kas build --target=mc:garage:minimal-image
kas build --target=mc:attic:minimal-image
```

Build for a specific machine using the `KAS_MACHINE` environment variable:

```
KAS_MACHINE=universal-pc-v4 kas build --target=mc:garage:workstation-image
```

Build the tiny bootable stress testing image (always universal-pc-v2):

```
kas build --target=mc:basement:dummy-image
```

The stress testing image runs Prime95 immediately on boot, and uses turbostat
to display thermal and power telemetry on the console. It includes
[Memtest86+](https://github.com/memtest86plus/memtest86plus), and the entire
bootable image compresses to 11MB.

### Kas

This repository uses [kas](https://kas.readthedocs.io/en/latest/) to manage the
Yocto layer dependencies and configs. Most distros support installing a recent
enough version through the package manager, or you can use pip:

```
sudo apt-get install kas  # Debian/Ubuntu
sudo emerge dev-build/kas  # Gentoo
pip3 install kas  # Pip
```

You can also run it directly from a local checkout of
[the git repo](https://github.com/siemens/kas.git), using the `run-kas` shortcut
in its root directory. You can manually install its dependecies through the
package manager:

```
sudo apt install python3-distro python3-yaml python3-jsonschema python3-git python3-gnupg  # Debian/Ubuntu
sudo emerge dev-python/distro dev-python/pyaml dev-python/jsonschema dev-python/gitpython dev-python/python-gnupg  # Gentoo
```

## Configuration

### IMAGEs

* **desktop-image**: GNOME3 desktop
* **desktop-workstation-image**: Self-hosting GNOME3 desktop workstation
* **workstation-image**: Self-hosting workstation with no graphics
* **minimal-image**: Barebone system with dhcpcd and sshd.
* **minimal-initramfs-image**: Test image (memtest86+ and prime95 stress test).

The `workstation` images contain everything needed to build all above targets.
The desktop images include MPV and Chromium.

### DISTROs

* **House**: Full-featured with systemd
* **Garage**: Console-only with sysvinit (no `desktop` images)
* **Attic**: Minimal with busybox (only `minimal` images)
* **Basement**: No networking or block support (only `minimal-initramfs` images)

### MACHINEs

Only 64-bit targets are supported.

#### Universal Targets

* `universal-pc-v2`
* `universal-pc-v3` (default)
* `universal-pc-v4`

### Minimalist Targets

* `minimal-pc` (no storage or networking)

#### Specific Targets

* `am21zen3`
* `bach`\*
* `beethoven`\*
* `brahms`\*
* `bmax1b`
* `handel`\*
* `haydn`\*
* `mahler`\*
* `nuc11pahi3`
* `nuc5cpyb`
* `nucd54250wyb`
* `nucde3815tykh`
* `telemann`\*
* `xps9300`
* `xps9340`

_\* One-off machines built at home by the author, provided as examples._

## Yocto Releases

By default, images are built off the most recent active release branch,
currently Walnascar (EOL Q4'25). You can also build Scarthgap (EOL Q2'28), or
build off the bleeding edge upstream master branches by replacing the symlink
in the repo root:

```
ln -sf kas/master.yaml .config.yaml
ln -sf kas/scarthgap.yaml .config.yaml
```

...or by simply passing the corresponding YAML to Kas as its first argument:

```
kas build kas/master.yaml --target=blah
```

Note that Scarthgap is not currently able to build the desktop images.

## Known Issues

* The GNOME network manager applet wifi support does not work.
* The GNOME sound control does not work at all.
* The GNOME touchpad settings page crashes the control panel.
* Because qemu-user lacks emulation support for some extensions of avx512, it is
  not possible to build the DISTRO=house for machine tunings which support them.
* Chromium is broken on master since the 1.85.1->1.86.0 Rust upgrade.
* Only the garage/attic-workstation/minimal images can be built on Scarthgap.
