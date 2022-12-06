import threading
import time

def thread(name: str):
    print("] Init thread", name)
    time.sleep(0.2)
    print("] Close thread", name)

def thread2():
    ct = threading.current_thread()
    while getattr(ct, "loop_over", True):
        print("] Looping")
    print("] loop end")
    
def main():
    print("> Init")
    
    tr = threading.Thread(target=thread2)
    tr.start()
    time.sleep(0.01)
    tr.loop_over = False
    time.sleep(1)
    print("> Main middle of thread")
    tr.join()
    print("> Main middle stopped")

if __name__ == "__main__":
    main()