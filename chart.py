import matplotlib.pyplot as plt
import random
import csv


def get_name(keyname: str) -> str:
    """Extracts the number of hash functions from the filename"""
    filter_type = keyname.split('-')[0]
    return f"{filter_type[-1:]} Hash(es)"

def plot_horizontal_lines(values: dict, name: str):
    """Plot horizontal lines for each value in values"""
    _, ax = plt.subplots()
    for value in values:
        color = random.random(), random.random(), random.random()
        line = ax.axhline(y=values[value], color=color, linestyle='-', linewidth=1)
        line.set_label(get_name(value))
        plt.legend()
    plt.ylim(0, 0.35)
    plt.savefig('plots/' + name + '.png')

def get_data(filename) -> float:
    """Get data from csv file"""
    with open(filename, 'r') as f:
        reader = csv.reader(f)
        data = list(reader)
        data.pop(0)
        data.pop(-1)
    return sum([float(row[0]) for row in data])/len(data)

def get_insert_speed(filename) -> float:
    """Get data from csv file"""
    with open(filename, 'r') as f:
        reader = csv.reader(f)
        data = list(reader)
        data.pop(0)
        data.pop(-1)
    return sum([float(row[1]) for row in data])/len(data)

def get_all_data(namelist) -> dict:
    """Get data from all csv files"""
    data = {}
    for name in namelist:
        data[name] = get_data(name)
    return data

def plot_array():
    prefix = 'BloomArray/'
    # Error rate for 100 elements with 1, 3 or 5 hash functions
    data = get_all_data([prefix + 'BloomArray1-100.csv', prefix + 'BloomArray3-100.csv', prefix + 'BloomArray5-100.csv'])
    plot_horizontal_lines(data, 'BloomArray100Elements')
    # Error rate for 500 elements with 1, 3 or 5 hash functions
    data = get_all_data([prefix + 'BloomArray1-500.csv', prefix + 'BloomArray3-500.csv', prefix + 'BloomArray5-500.csv'])
    plot_horizontal_lines(data, 'BloomArray500Elements')
    # Error rate for 1000 elements with 1, 3 or 5 hash functions
    data = get_all_data([prefix + 'BloomArray1-1000.csv', prefix + 'BloomArray3-1000.csv', prefix + 'BloomArray5-1000.csv'])
    plot_horizontal_lines(data, 'BloomArray1000Elements')

    data = get_all_data([prefix + 'BloomArray3-100.csv', prefix + 'BloomArray3-500.csv', prefix + 'BloomArray3-1000.csv'])
    plot_horizontal_lines(data, 'BloomArray3Hashes')

def plot_array_list():
    prefix = 'BloomArrayList/'
    # Error rate for 100 elements with 1, 3 or 5 hash functions
    data = get_all_data([prefix + 'BloomArrayList1-100.csv', prefix + 'BloomArrayList3-100.csv', prefix + 'BloomArrayList5-100.csv'])
    plot_horizontal_lines(data, 'BloomArrayList100Elements')
    # Error rate for 500 elements with 1, 3 or 5 hash functions
    data = get_all_data([prefix + 'BloomArrayList1-500.csv', prefix + 'BloomArrayList3-500.csv', prefix + 'BloomArrayList5-500.csv'])
    plot_horizontal_lines(data, 'BloomArrayList500Elements')
    # Error rate for 1000 elements with 1, 3 or 5 hash functions
    data = get_all_data([prefix + 'BloomArrayList1-1000.csv', prefix + 'BloomArrayList3-1000.csv', prefix + 'BloomArrayList5-1000.csv'])
    plot_horizontal_lines(data, 'BloomArrayList1000Elements')

def plot_linked():
    prefix = "BloomLinked/"
    # Error rate for 100 elements with 1, 3 or 5 hash functions
    data = get_all_data([prefix + 'BloomLinked1-100.csv', prefix + 'BloomLinked3-100.csv', prefix + 'BloomLinked5-100.csv'])
    plot_horizontal_lines(data, 'BloomLinked100Elements')
    # Error rate for 500 elements with 1, 3 or 5 hash functions
    data = get_all_data([prefix + 'BloomLinked1-500.csv', prefix + 'BloomLinked3-500.csv', prefix + 'BloomLinked5-500.csv'])
    plot_horizontal_lines(data, 'BloomLinked500Elements')
    # Error rate for 1000 elements with 1, 3 or 5 hash functions
    data = get_all_data([prefix + 'BloomLinked1-1000.csv', prefix + 'BloomLinked3-1000.csv', prefix + 'BloomLinked5-1000.csv'])
    plot_horizontal_lines(data, 'BloomLinked1000Elements')

def plot_insert_speed():
    array_speed = get_insert_speed('BloomArray/BloomArray3-1000.csv')
    array_list_speed = get_insert_speed('BloomArrayList/BloomArrayList3-1000.csv')
    linked_speed = get_insert_speed('BloomLinked/BloomLinked3-1000.csv')
    _, ax = plt.subplots()
    line = ax.axhline(y=array_speed, color='r', linestyle='-', linewidth=1)
    line.set_label("Array")
    plt.legend()
    line = ax.axhline(y=array_list_speed, color='g', linestyle='-', linewidth=1)
    line.set_label("Array List")
    plt.legend()
    line = ax.axhline(y=linked_speed, color='b', linestyle='-', linewidth=1)
    line.set_label("Linked List")
    plt.legend()
    plt.savefig('plots/InsertSpeed.png')

if __name__ == '__main__':
    # plot_array()
    # plot_array_list()
    # plot_linked()
    plot_insert_speed()
    