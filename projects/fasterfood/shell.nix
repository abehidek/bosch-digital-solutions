# shell.nix
{ pkgs ? import <nixpkgs> {} }:
let
  unstable = import (fetchTarball https://nixos.org/channels/nixos-unstable/nixexprs.tar.xz) { };
in
pkgs.mkShell {
  buildInputs = [
    unstable.jdk
    pkgs.pfetch
  ];
  shellHook = ''
    # maybe set more env-vars
    # To compile and run this project the scripts are:
    # javac -d bin ./src/**/*.java && java -cp ./bin src.Main
    echo "initing..."
    # alias jjm="javac *.java && java Main"
  '';
}

